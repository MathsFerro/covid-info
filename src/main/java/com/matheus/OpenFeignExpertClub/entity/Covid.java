package com.matheus.OpenFeignExpertClub.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "covid_info")
public class Covid {

  @Id
  private Integer uid;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "state_id")
  private State state;
  private Integer cases;
  private Integer deaths;
  private Integer suspects;
  private Integer refuses;
  private LocalDateTime datetime;

}
