package com.matheus.OpenFeignExpertClub.service.impl;


import com.matheus.OpenFeignExpertClub.client.AddressAPI;
import com.matheus.OpenFeignExpertClub.client.CovidAPI;
import com.matheus.OpenFeignExpertClub.dto.AddressDTO;
import com.matheus.OpenFeignExpertClub.dto.CovidDTO;
import com.matheus.OpenFeignExpertClub.dto.StateDTO;
import com.matheus.OpenFeignExpertClub.entity.State;
import com.matheus.OpenFeignExpertClub.entity.User;
import com.matheus.OpenFeignExpertClub.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

  @InjectMocks
  private UserServiceImpl userService;
  @Mock
  private UserRepository userRepository;
  @Mock
  private AddressAPI addressAPI;
  @Mock
  private CovidAPI covidAPI;

  private User user;
  private AddressDTO addressDTO;
  private CovidDTO covidDTO;
  private State state;

  @Before
  public void setUp() {
    String userId = "1";

    user = new User();
    covidDTO = new CovidDTO();
    state = new State();

    addressDTO = new AddressDTO();
    addressDTO.setCity("São Paulo");
    addressDTO.setZipCode("033");
    addressDTO.setState("SP");
    addressDTO.setAddress("Teste");

    state.setId(1L);
    state.setName("SP");

    covidDTO.setState(state);
    covidDTO.setDeaths(10);
    covidDTO.setCases(20);
    covidDTO.setSuspects(50);
    covidDTO.setUf("SP");
    covidDTO.setUid(1);

    user.setId(userId);
    user.setCreatedAt(LocalDateTime.now());
    user.setName("Matheus");
    user.setZipCode("123");

    Mockito.when(userRepository.findById(userId)).thenReturn(Optional.of(user));
    Mockito.when(addressAPI.findByCep(user.getZipCode())).thenReturn(addressDTO);
  }

  @Test
  public void testFindByIdWithCovidInfo() {
    userService.findByIdWithCovidInfo(user.getId());
  }

  @Test
  public void testCreate() {
    userService.create(user);
  }

}