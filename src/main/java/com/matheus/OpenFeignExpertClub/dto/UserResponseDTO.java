package com.matheus.OpenFeignExpertClub.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDTO {

  private String id;
  private String name;
  private String email;
  private String zipCode;
  private String address;
  private String district;
  private String city;
  private StateDTO stateDTO;
  private CovidDTO covidDTO;
  private LocalDateTime createdAt;

}
