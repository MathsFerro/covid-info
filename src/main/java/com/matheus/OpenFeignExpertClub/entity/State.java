package com.matheus.OpenFeignExpertClub.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "state")
public class State {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
//  @OneToOne(cascade = CascadeType.ALL)
//  private Covid covid;
  @OneToMany(mappedBy = "state")
  private List<User> user;

}
