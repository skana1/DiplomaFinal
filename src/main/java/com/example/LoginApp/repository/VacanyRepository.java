package com.example.LoginApp.repository;

import com.example.LoginApp.models.Vacancy;
import com.example.LoginApp.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacanyRepository extends JpaRepository<Vacancy, Integer> {
}
