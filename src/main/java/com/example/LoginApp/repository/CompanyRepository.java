package com.example.LoginApp.repository;

import com.example.LoginApp.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findCompanyById(Integer id);

    void deleteCompanyById(Integer id);
}
