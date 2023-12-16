package com.user.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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


}
