package com.example.LoginApp.repository;

import com.example.LoginApp.models.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends JpaRepository<Companies, Integer> {
}
