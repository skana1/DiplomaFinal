package com.example.LoginApp.service;

import com.example.LoginApp.repository.ApplicationsRepository;
import com.example.LoginApp.exception.ApplicationNotFoundException;
import com.example.LoginApp.models.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationsRepository applicationsRepository;

    public List<Application> findAllApplications() {
        return applicationsRepository.findAll();
    }

    public Application addApplication(Application application) {
        return applicationsRepository.save(application);
    }

    public Application findApplicationById(Integer id) {
        return applicationsRepository.findApplicationById(id).orElseThrow(() ->
                new ApplicationNotFoundException("Application by Id" + id + "was not found"));
    }

    public Application updateApplication(Application application) {
        Optional<Application> existingApplication = applicationsRepository.findById(application.getId());
        if(existingApplication.isPresent()){
            Application updatedApplication = existingApplication.get();
            updatedApplication.setProfiles(application.getProfiles());
            updatedApplication.setVacancy((application.getVacancy()));

            return applicationsRepository.save(updatedApplication);
        } else{
          throw   new ApplicationNotFoundException("Application by Id" + application.getId() + "was not found");
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        applicationsRepository.deleteApplicationById(id);
    }
}
