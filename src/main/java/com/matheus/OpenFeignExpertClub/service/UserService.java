package com.matheus.OpenFeignExpertClub.service;

import com.matheus.OpenFeignExpertClub.dto.UserResponseDTO;
import com.matheus.OpenFeignExpertClub.entity.User;

import java.util.Optional;

public interface UserService {

  Optional<UserResponseDTO> findByIdWithCovidInfo(String id);
  Optional<UserResponseDTO> findById(String id);
  UserResponseDTO create(User user);

}
