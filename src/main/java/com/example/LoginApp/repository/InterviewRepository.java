package com.example.LoginApp.repository;

import com.example.LoginApp.models.Employee;
import com.example.LoginApp.models.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterviewRepository extends JpaRepository<Interview, Integer> {
    Optional<Interview> findInterviewById(Integer id);

    void deleteInterviewById(Integer id);
}
