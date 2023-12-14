package com.user.api.DTO;

import java.time.LocalDate;

import com.user.api.models.Level;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserDTO(

  @NotBlank
  String name,

  @Email
  String email,

  @NotNull
  @Past
  LocalDate birthDate,

  @NotNull
  @Size(min = 8, max = 16)
  @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
  String password,

  @NotNull
  @Size(min = 8, max = 16)
  @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")
  String confirmPassword,

  @NotNull
  Level level
) {}
