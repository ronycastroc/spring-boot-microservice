package com.user.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.user.api.DTO.UserDTO;
import com.user.api.exception.UserNotFoundException;
import com.user.api.models.User;
import com.user.api.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {
  
  @Autowired
  private UserService service;

  @PostMapping
  public ResponseEntity<String> create(@RequestBody @Valid UserDTO req) {
    try {
      service.create(new User(req));
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
  
  @GetMapping
  public List<User> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getById(@PathVariable Long id) {
     try {
        Optional<User> user = service.getById(id);
        return ResponseEntity.ok(user);
    } catch (UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> update(@PathVariable Long id, @RequestBody @Valid UserDTO req) {
    try {
      service.update(id, req);
      return ResponseEntity.ok("User updated successfully");
    } catch (UserNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(value = HttpStatus.NO_CONTENT)
  public ResponseEntity<String> delete(@PathVariable Long id) {    
    try {
      service.delete(id);
      return ResponseEntity.ok("User deleted successfully");
    } catch (UserNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
  }

}
