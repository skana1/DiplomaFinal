package com.example.LoginApp.repository;

import com.example.LoginApp.models.Profiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfiliesRepository extends JpaRepository<Profiles, Integer> {
}
