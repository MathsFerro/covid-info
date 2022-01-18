package com.matheus.OpenFeignExpertClub.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class User {

  @Id
  private String id;
  private String name;
  private String email;
  @Column(name = "zip_code")
  private String zipCode;
  private String address;
  private String district;
  private String city;
  @ManyToOne
  @JoinColumn(name = "state_id")
  private State state;
  @Column(name = "created_at")
  private LocalDateTime createdAt;

}
