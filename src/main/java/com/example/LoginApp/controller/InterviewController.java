package com.example.LoginApp.controller;

import com.example.LoginApp.models.Interview;
import com.example.LoginApp.service.InterviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/interview")
@RequiredArgsConstructor
public class InterviewController {

    private final InterviewService interviewService;

    @GetMapping("/all")
    public ResponseEntity<List<Interview>> getAllInterviews(){
        List<Interview> interviewList = interviewService.getAllInterviews();
        return new ResponseEntity<>(interviewList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Interview> findInterviewById(@PathVariable("id") Integer id){
        Interview interview = interviewService.findInterviewById(id);
        return new ResponseEntity<>(interview, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Interview> createInterview(@RequestBody Interview interview){
        Interview newInterview = interviewService.createInterview(interview);
        return new ResponseEntity<>(newInterview, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Interview> updateInterview(@RequestBody Interview interview){
        Interview updatedInterview = interviewService.updateInterview(interview);
        return new ResponseEntity<>(updatedInterview, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Interview> deleteInterview(@PathVariable("id") Integer id){
        interviewService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
