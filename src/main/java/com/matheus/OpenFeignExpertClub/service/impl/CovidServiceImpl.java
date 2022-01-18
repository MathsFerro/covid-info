package com.matheus.OpenFeignExpertClub.service.impl;

import com.matheus.OpenFeignExpertClub.client.CovidAPI;
import com.matheus.OpenFeignExpertClub.dto.CovidDTO;
import com.matheus.OpenFeignExpertClub.dto.StateDTO;
import com.matheus.OpenFeignExpertClub.dto.mapper.CovidMapper;
import com.matheus.OpenFeignExpertClub.dto.mapper.StateMapper;
import com.matheus.OpenFeignExpertClub.entity.Covid;
import com.matheus.OpenFeignExpertClub.entity.State;
import com.matheus.OpenFeignExpertClub.repository.CovidRepository;
import com.matheus.OpenFeignExpertClub.service.CovidService;
import com.matheus.OpenFeignExpertClub.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CovidServiceImpl implements CovidService {

  @Autowired
  private StateService stateService;
  @Autowired
  private CovidRepository covidRepository;
  @Autowired
  private CovidAPI covidAPI;

  @Override
  public CovidDTO add(CovidDTO covidDTO) {
    Covid covid = CovidMapper.fromDTO(covidDTO);
    covidRepository.save(covid);

    return covidDTO;
  }

  @Override
  public Optional<CovidDTO> findCovidByStateId(Long stateId) {
    Optional<Covid> covidOptional = covidRepository.findByStateId(stateId);
    if(covidOptional.isEmpty()) {
      return Optional.empty();
    }

    CovidDTO dto = CovidMapper.toDTO(covidOptional.get());

    return Optional.of(dto);
  }

  public Optional<CovidDTO> getCovidInfoByState(StateDTO stateDTO) {
    Optional<CovidDTO> covidDTOOptional = this.findCovidByStateId(stateDTO.getId());
    if(covidDTOOptional.isPresent()) {
      CovidDTO covidDTO = covidDTOOptional.get();
      return Optional.of(covidDTO);
    }

    try {
      CovidDTO covidDTO = covidAPI.getInfoByUF(stateDTO.getName());

      if (covidDTO != null) {
        State state = StateMapper.fromDTO(stateDTO);
        covidDTO.setState(state);

        this.add(covidDTO);

        return Optional.of(covidDTO);
      }
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    }

    return Optional.empty();
  }
}
