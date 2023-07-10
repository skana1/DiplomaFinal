package com.example.LoginApp.controller;

import com.example.LoginApp.models.Interview;
import com.example.LoginApp.models.Profile;
import com.example.LoginApp.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor

public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/all")
    public ResponseEntity<List<Profile>> getAllProfiles(){
        List<Profile> profileListList = profileService.getAllProfiles();
        return new ResponseEntity<>(profileListList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Profile> findProfileById(@PathVariable("id") Integer id){
        Profile profile = profileService.findProfileById(id);
        return new ResponseEntity<>(profile, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile){
        Profile newProfile = profileService.createProfile(profile);
        return new ResponseEntity<>(newProfile, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile){
        Profile updatedProfile = profileService.updateProfile(profile);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Profile> deleteProfile(@PathVariable("id") Integer id){
        profileService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
