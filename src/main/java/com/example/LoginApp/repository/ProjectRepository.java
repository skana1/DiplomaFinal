package com.example.LoginApp.repository;

import com.example.LoginApp.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Optional<Project> findProjectById(Integer id);

    void deleteProjectById(Integer id);
}
