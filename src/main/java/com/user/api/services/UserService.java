package com.user.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.user.api.DTO.UserDTO;
import com.user.api.exception.UserNotFoundException;
import com.user.api.models.User;
import com.user.api.repository.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository repository;

  private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public void create(User user) {
    validatePasswords(user);

    user.setPassword(passwordEncoder.encode(user.getPassword()));
    
    repository.save(user);
  }

  private void validatePasswords(User user) {
    String password = user.getPassword();
    String confirmPassword = user.getConfirmPassword();

    if (!password.equals(confirmPassword)) {
        throw new IllegalArgumentException("Passwords are not the same.");
    }
  }

  public List<User> getAll() {
    return repository.findAll();
  }

  public Optional<User> getById(Long id) {
    Optional<User> user = repository.findById(id);

    if (!user.isPresent()) throw new UserNotFoundException(id);

    return user;
  }

  public void update(Long id, UserDTO user) {
    Optional<User> optionalPerson = repository.findById(id);

    if (optionalPerson.isEmpty()) throw new UserNotFoundException(id);

    optionalPerson.map(r -> {
      r.setName(user.name());
      r.setEmail(user.email());
      r.setBirthDate(user.birthDate());
      r.setLevel(user.level().getDescription());
      r.setPassword(user.password());
      return repository.save(r);
    });
    
  }

}
