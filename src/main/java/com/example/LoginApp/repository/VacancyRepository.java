package com.example.LoginApp.repository;

import com.example.LoginApp.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {
    Optional<Vacancy> findVacancyById(Integer id);

    void deleteVacancyById(Integer id);
}
