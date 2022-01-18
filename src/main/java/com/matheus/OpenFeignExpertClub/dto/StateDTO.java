package com.matheus.OpenFeignExpertClub.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.matheus.OpenFeignExpertClub.entity.Covid;
import com.matheus.OpenFeignExpertClub.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StateDTO {

  private Long id;
  private String name;
//  @JsonBackReference
//  private Covid covid;
  @JsonBackReference
  private List<User> user;

}
