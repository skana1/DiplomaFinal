package com.example.LoginApp.repository;

import com.example.LoginApp.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    Optional<Profile> findProfileById(Integer id);

    void deleteProfileById(Integer id);
}
