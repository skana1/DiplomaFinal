package com.example.LoginApp.service;

import com.example.LoginApp.exception.InterviewNotFoundException;
import com.example.LoginApp.models.Interview;
import com.example.LoginApp.repository.InterviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InterviewService {

    private final InterviewRepository interviewRepository;

    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    public Interview createInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    public Interview findInterviewById(Integer id) {
        return interviewRepository.findInterviewById(id).orElseThrow(() ->
                new InterviewNotFoundException("Interview by Id: " + id + " was not found"));
    }

    public Interview updateInterview(Interview interview) {
        Optional<Interview> existingInterview = interviewRepository.findById(interview.getId());
        if (existingInterview.isPresent()) {
            Interview updatedInterview = existingInterview.get();
            updatedInterview.setProfiles(interview.getProfiles());
            updatedInterview.setVacancy(interview.getVacancy());
            updatedInterview.setData(interview.getData());
            updatedInterview.setTime(interview.getTime());
            updatedInterview.setDuration(interview.getDuration());
            updatedInterview.setTitle(interview.getTitle());
            updatedInterview.setNotes(interview.getNotes());

            return interviewRepository.save(updatedInterview);
        } else {
            throw new InterviewNotFoundException("Interview by Id " + interview.getId() + " was not found");
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        interviewRepository.deleteInterviewById(id);
    }
}




























