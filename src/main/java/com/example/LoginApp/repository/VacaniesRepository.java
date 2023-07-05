package com.example.LoginApp.repository;

import com.example.LoginApp.models.Vacanies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacaniesRepository extends JpaRepository<Vacanies, Integer> {
}
