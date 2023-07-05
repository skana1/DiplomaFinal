package com.example.LoginApp.repository;

import com.example.LoginApp.models.Applications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationsRepository extends JpaRepository<Applications, Integer> {
}
