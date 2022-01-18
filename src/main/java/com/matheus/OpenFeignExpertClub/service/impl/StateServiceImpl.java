package com.matheus.OpenFeignExpertClub.service.impl;

import com.matheus.OpenFeignExpertClub.dto.AddressDTO;
import com.matheus.OpenFeignExpertClub.entity.State;
import com.matheus.OpenFeignExpertClub.repository.StateRepository;
import com.matheus.OpenFeignExpertClub.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StateServiceImpl implements StateService {

  @Autowired
  private StateRepository stateRepository;

  @Override
  public State addState(State state) {
    return stateRepository.save(state);
  }

  @Override
  public Optional<State> findByNameContaining(String name) {
    Optional<State> stateOptional = stateRepository.findByNameContaining(name);
    if(stateOptional.isEmpty()) {
      return Optional.empty();
    }

    State state = stateOptional.get();

    return Optional.of(state);
  }

  public State handleCreateStateByAddressDTO(AddressDTO addressDTO) {
    Optional<State> stateOptional = this.findByNameContaining(addressDTO.getState());
    if(stateOptional.isEmpty()) {
      State state = new State();
      state.setName(addressDTO.getState());
      return this.addState(state);
    }

    return stateOptional.get();
  }
}
