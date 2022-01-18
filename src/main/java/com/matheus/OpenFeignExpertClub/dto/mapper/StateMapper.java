package com.matheus.OpenFeignExpertClub.dto.mapper;

import com.matheus.OpenFeignExpertClub.dto.StateDTO;
import com.matheus.OpenFeignExpertClub.entity.State;
import org.springframework.beans.BeanUtils;

public class StateMapper {

  public static StateDTO toDTO(State state) {
    StateDTO dto = new StateDTO();
    BeanUtils.copyProperties(state, dto);
    return dto;
  }

  public static State fromDTO(StateDTO stateDTO) {
    State state = new State();
    BeanUtils.copyProperties(stateDTO, state);
    return state;
  }

}
