package com.example.LoginApp.repository;

import com.example.LoginApp.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    void deleteTaskById(Integer id);

    Optional<Task> findTaskById(Integer id);
}
