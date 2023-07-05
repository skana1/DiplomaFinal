package com.example.LoginApp.repository;

import com.example.LoginApp.models.Companies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompaniesRepository extends JpaRepository<Companies, Integer> {
}
