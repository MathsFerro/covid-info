package com.matheus.OpenFeignExpertClub.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AddressDTO implements Serializable {

  private static final long serialVersionUID = 528234412818666066L;

  @JsonProperty(value = "cep")
  private String zipCode;
  @JsonProperty(value = "logradouro")
  private String address;
  @JsonProperty(value = "bairro")
  private String district;
  @JsonProperty(value = "cidade")
  private String city;
  @JsonProperty(value = "estado")
  private String state;

}
