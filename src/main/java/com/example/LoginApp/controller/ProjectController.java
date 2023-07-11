package com.example.LoginApp.controller;

import com.example.LoginApp.models.Profile;
import com.example.LoginApp.models.Project;
import com.example.LoginApp.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/all")
    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> projectList = projectService.getAllProject();
        return new ResponseEntity<>(projectList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Project> findProjectById(@PathVariable("id") Integer id){
        Project project = projectService.findProjectById(id);
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        Project newProject = projectService.createProject(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Project> updateProject(@RequestBody Project project){
        Project updatedProject = projectService.updateProject(project);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable("id") Integer id){
        projectService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}















