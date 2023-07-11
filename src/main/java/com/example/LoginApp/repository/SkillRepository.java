package com.example.LoginApp.repository;

import com.example.LoginApp.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    Optional<Skill> findSkillById(Integer id);

    void deleteSkillById(Integer id);
}
