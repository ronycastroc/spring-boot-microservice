package com.user.api.models;

import java.time.LocalDate;

import com.user.api.DTO.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "\"user\"")
@NoArgsConstructor
public class User {
  
  public User(UserDTO req) {
    this.name = req.name();
    this.email = req.email();
    this.birthDate = req.birthDate();
    this.password = req.password();
    this.confirmPassword = req.confirmPassword();
    this.level = req.level().getDescription();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 50, nullable = false)
  private String name;

  @Column(length = 100, nullable = false)
  private String email;

  @Column(length = 10, nullable = false)
  private LocalDate birthDate;

  @Column(length = 100, nullable = false)
  private String password;

  @Column(length = 100, nullable = false)
  private String confirmPassword;

  @Column(nullable = false)
  private String level;
}
