package com.matheus.OpenFeignExpertClub.service;

import com.matheus.OpenFeignExpertClub.dto.AddressDTO;
import com.matheus.OpenFeignExpertClub.entity.State;

import java.util.Optional;

public interface StateService {

  State addState(State state);
  Optional<State> findByNameContaining(String name);
  State handleCreateStateByAddressDTO(AddressDTO addressDTO);

}
