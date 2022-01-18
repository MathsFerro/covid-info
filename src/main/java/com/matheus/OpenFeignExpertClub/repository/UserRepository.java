package com.matheus.OpenFeignExpertClub.repository;

import com.matheus.OpenFeignExpertClub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
