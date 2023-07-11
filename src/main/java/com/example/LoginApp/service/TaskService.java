package com.example.LoginApp.service;

import com.example.LoginApp.exception.ProjectNotFoundException;
import com.example.LoginApp.exception.SkillNotFoundException;
import com.example.LoginApp.exception.TaskNotFoundException;
import com.example.LoginApp.models.Skill;
import com.example.LoginApp.models.Task;
import com.example.LoginApp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task findTaskById(Integer id) {
        return taskRepository.findTaskById(id).orElseThrow(() ->
                new TaskNotFoundException("Task by Id: " + id + " was not found"));
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        Optional<Task> existingTask = taskRepository.findById(task.getId());
        if (existingTask.isPresent()) {
            Task updatedTask = existingTask.get();
            updatedTask.setEmployee(task.getEmployee());
            updatedTask.setProjects(task.getProjects());
            updatedTask.setLevel(task.getLevel());
            updatedTask.setName(task.getName());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setStatus(task.getStatus());

            return taskRepository.save(updatedTask);
        } else {
            throw new TaskNotFoundException("Task by Id " + task.getId() + " was not found");
        }
    }



    @Transactional
    public void deleteById(Integer id) {
        taskRepository.deleteTaskById(id);
    }
}
