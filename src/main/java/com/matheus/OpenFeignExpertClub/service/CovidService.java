package com.matheus.OpenFeignExpertClub.service;

import com.matheus.OpenFeignExpertClub.dto.CovidDTO;
import com.matheus.OpenFeignExpertClub.dto.StateDTO;

import java.util.Optional;

public interface CovidService {

  CovidDTO add(CovidDTO covid);
  Optional<CovidDTO> findCovidByStateId(Long stateId);
  Optional<CovidDTO> getCovidInfoByState(StateDTO stateDTO);

}
