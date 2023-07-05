package com.example.LoginApp.repository;

import com.example.LoginApp.models.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {
}
