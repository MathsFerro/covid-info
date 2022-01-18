package com.matheus.OpenFeignExpertClub.dto.mapper;

import com.matheus.OpenFeignExpertClub.dto.CovidDTO;
import com.matheus.OpenFeignExpertClub.entity.Covid;
import org.springframework.beans.BeanUtils;

public class CovidMapper {

  private CovidMapper() { }

  public static CovidDTO toDTO(Covid covid) {
    CovidDTO dto = new CovidDTO();
    BeanUtils.copyProperties(covid, dto);
    return dto;
  }

  public static Covid fromDTO(CovidDTO covidDTO) {
    Covid covid = new Covid();
    BeanUtils.copyProperties(covidDTO, covid);
    return covid;
  }

}
