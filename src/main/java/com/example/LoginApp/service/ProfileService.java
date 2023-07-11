package com.example.LoginApp.service;

import com.example.LoginApp.exception.InterviewNotFoundException;
import com.example.LoginApp.exception.ProfileNotFoundException;
import com.example.LoginApp.models.Profile;
import com.example.LoginApp.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public Profile findProfileById(Integer id) {
        return profileRepository.findProfileById(id).orElseThrow(() ->
                new InterviewNotFoundException("Profile by Id: " + id + " was not found"));
    }


    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile updateProfile(Profile profile) {
        Optional<Profile> existingProfile = profileRepository.findById(profile.getId());
        if (existingProfile.isPresent()) {
            Profile updatedProfile = existingProfile.get();
            updatedProfile.setApplications(profile.getApplications());
            updatedProfile.setSkills(profile.getSkills());
            updatedProfile.setEmployee(profile.getEmployee());
            updatedProfile.setInterview(profile.getInterview());
            updatedProfile.setFull_name(profile.getFull_name());
            updatedProfile.setEmail(profile.getEmail());
            updatedProfile.setPhone_number(profile.getPhone_number());
            updatedProfile.setDob(profile.getDob());
            updatedProfile.setCountry(profile.getCountry());
            updatedProfile.setCity(profile.getCity());
            updatedProfile.setAddress(profile.getAddress());
            updatedProfile.setGender(profile.getGender());
            updatedProfile.setExperience(profile.getExperience());

            return profileRepository.save(updatedProfile);
        } else {
            throw new ProfileNotFoundException("Profile by Id " + profile.getId() + " was not found");
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        profileRepository.deleteProfileById(id);
    }
}
