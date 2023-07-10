package com.example.LoginApp.controller;


import com.example.LoginApp.service.ApplicationService;
import com.example.LoginApp.models.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping("/all")
    public ResponseEntity<List<Application>> getAllApplications (){
        List<Application> applications = applicationService.findAllApplications();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Application> addApplication(Application application){
        Application newApplication = applicationService.addApplication(application);
        return new ResponseEntity<>(newApplication, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Integer id){
        Application application = applicationService.findApplicationById(id);
        return new ResponseEntity<>(application, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Application> updateApplication(@RequestBody Application application){
        Application updateApplication = applicationService.updateApplication(application);
        return new ResponseEntity<>(updateApplication, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Application> deleteApplication(@PathVariable("id") Integer id){
        applicationService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

























