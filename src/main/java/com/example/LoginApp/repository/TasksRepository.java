package com.example.LoginApp.repository;

import com.example.LoginApp.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Tasks, Integer> {
}
