package com.user.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.api.models.User;

public interface UserRepository extends JpaRepository<User, Long> {}
