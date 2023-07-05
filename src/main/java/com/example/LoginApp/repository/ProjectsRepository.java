package com.example.LoginApp.repository;

import com.example.LoginApp.models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectsRepository extends JpaRepository<Projects, Integer> {
}
