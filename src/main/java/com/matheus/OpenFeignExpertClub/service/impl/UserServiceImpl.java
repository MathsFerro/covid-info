package com.matheus.OpenFeignExpertClub.service.impl;

import com.matheus.OpenFeignExpertClub.client.AddressAPI;
import com.matheus.OpenFeignExpertClub.client.CovidAPI;
import com.matheus.OpenFeignExpertClub.dto.AddressDTO;
import com.matheus.OpenFeignExpertClub.dto.CovidDTO;
import com.matheus.OpenFeignExpertClub.dto.StateDTO;
import com.matheus.OpenFeignExpertClub.dto.UserResponseDTO;
import com.matheus.OpenFeignExpertClub.dto.mapper.CovidMapper;
import com.matheus.OpenFeignExpertClub.dto.mapper.UserMapper;
import com.matheus.OpenFeignExpertClub.entity.Covid;
import com.matheus.OpenFeignExpertClub.entity.State;
import com.matheus.OpenFeignExpertClub.entity.User;
import com.matheus.OpenFeignExpertClub.repository.UserRepository;
import com.matheus.OpenFeignExpertClub.service.CovidService;
import com.matheus.OpenFeignExpertClub.service.StateService;
import com.matheus.OpenFeignExpertClub.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private StateService stateService;
  @Autowired
  private CovidService covidService;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AddressAPI addressAPI;

  @Override
  public Optional<UserResponseDTO> findByIdWithCovidInfo(String id) {
    Optional<UserResponseDTO> userResponseDTOOptional = this.findById(id);

    if(userResponseDTOOptional.isPresent()) {
      UserResponseDTO dto = userResponseDTOOptional.get();
      Optional<CovidDTO> covidDTOOptional = covidService.getCovidInfoByState(dto.getStateDTO());
      covidDTOOptional.ifPresent(dto::setCovidDTO);

      return Optional.of(dto);
    }

    return Optional.empty();
  }

  @Override
  public Optional<UserResponseDTO> findById(String id) {
    Optional<User> optionalUser = userRepository.findById(id);
    if (optionalUser.isEmpty()) {
      return Optional.empty();
    }

    User user = optionalUser.get();
    UserResponseDTO userResponseDTO = UserMapper.toDTO(user);

    return Optional.of(userResponseDTO);
  }

  public UserResponseDTO create(User user) {
    user.setId(UUID.randomUUID().toString());
    user.setCreatedAt(LocalDateTime.now());

    try {
      AddressDTO addressDTO = addressAPI.findByCep(user.getZipCode());
      BeanUtils.copyProperties(addressDTO, user);

      State state = stateService.handleCreateStateByAddressDTO(addressDTO);
      user.setState(state);

      userRepository.save(user);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return UserMapper.toDTO(user);
  }
}
