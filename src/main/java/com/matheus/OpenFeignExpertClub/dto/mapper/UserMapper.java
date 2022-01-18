package com.matheus.OpenFeignExpertClub.dto.mapper;

import com.matheus.OpenFeignExpertClub.dto.UserResponseDTO;
import com.matheus.OpenFeignExpertClub.entity.User;
import org.springframework.beans.BeanUtils;

public class UserMapper {

  public static User fromDTO(UserResponseDTO dto) {
    User user = new User();
    BeanUtils.copyProperties(dto, user);
    return user;
  }

  public static UserResponseDTO toDTO(User user) {
    UserResponseDTO dto = new UserResponseDTO();
    BeanUtils.copyProperties(user, dto);
    dto.setStateDTO(StateMapper.toDTO(user.getState()));

    return dto;
  }

}
