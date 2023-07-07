package com.example.LoginApp.repository;

import com.example.LoginApp.models.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacaniesRepository extends JpaRepository<Vacancies, Integer> {
}
