package com.matheus.OpenFeignExpertClub.repository;

import com.matheus.OpenFeignExpertClub.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

  Optional<State> findByNameContaining(String name);

}
