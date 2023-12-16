package com.user.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.api.models.User;
import com.user.api.repository.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository repository;

  public void create(User user) {
    if (!user.getPassword().equals(user.getConfirmPassword())) {
      throw new IllegalArgumentException("Passwords are not the same");
    }
    
    repository.save(user);

  }
}
