package com.matheus.OpenFeignExpertClub.repository;

import com.matheus.OpenFeignExpertClub.entity.Covid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CovidRepository extends JpaRepository<Covid, Integer> {

  Optional<Covid> findByStateId(Long stateId);

}
