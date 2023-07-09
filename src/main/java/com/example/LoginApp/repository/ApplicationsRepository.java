package com.example.LoginApp.repository;

import com.example.LoginApp.models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationsRepository extends JpaRepository<Application, Integer> {
    Optional<Application> findApplicationById(Integer id);

    void deleteApplicationById(Integer id);
}
