package com.matheus.OpenFeignExpertClub.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheus.OpenFeignExpertClub.entity.State;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
public class CovidDTO implements Serializable {

  private Integer uid;
  private String uf;
  @JsonIgnore
  private State state;
  private Integer cases;
  private Integer deaths;
  private Integer suspects;
  private Integer refuses;
  private LocalDateTime datetime;

}
