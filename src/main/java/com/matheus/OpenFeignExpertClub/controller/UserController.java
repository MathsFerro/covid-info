package com.matheus.OpenFeignExpertClub.controller;

import com.matheus.OpenFeignExpertClub.dto.UserResponseDTO;
import com.matheus.OpenFeignExpertClub.entity.User;
import com.matheus.OpenFeignExpertClub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<UserResponseDTO> create(@RequestBody User user) {
    return ResponseEntity.ok(userService.create(user));
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserResponseDTO> findByIdWithCovidInfo(@PathVariable("id") String id) {
    return userService.findByIdWithCovidInfo(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
  }

}
