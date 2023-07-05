package com.example.LoginApp.repository;

import com.example.LoginApp.models.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Integer> {
}
