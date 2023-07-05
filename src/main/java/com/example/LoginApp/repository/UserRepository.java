package com.example.LoginApp.repository;

import com.example.LoginApp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findAllByEmail(String email);
}
