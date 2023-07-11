package com.example.LoginApp.service;

import com.example.LoginApp.exception.VacancyNotFoundException;
import com.example.LoginApp.models.Vacancy;
import com.example.LoginApp.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    public List<Vacancy> getAllVacancies() {
        return vacancyRepository.findAll();
    }

    public Vacancy findVacancyById(Integer id) {
        return vacancyRepository.findVacancyById(id).orElseThrow(() ->
                new VacancyNotFoundException("Vacancy by Id: " + id + " was not found"));
    }

    public Vacancy createVacancy(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    public Vacancy updateVacancy(Vacancy vacancy) {
        Optional<Vacancy> existingVacancy = vacancyRepository.findById(vacancy.getId());
        if (existingVacancy.isPresent()) {
            Vacancy updatedVacancy = existingVacancy.get();
            updatedVacancy.setCompany(vacancy.getCompany());
            updatedVacancy.setPosition(vacancy.getPosition());
            updatedVacancy.setMin_salary(vacancy.getMin_salary());
            updatedVacancy.setMax_salary(vacancy.getMax_salary());
            updatedVacancy.setDescription(vacancy.getDescription());

            return vacancyRepository.save(updatedVacancy);
        } else {
            throw new VacancyNotFoundException("Vacancy by Id " + vacancy.getId() + " was not found");
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        vacancyRepository.deleteVacancyById(id);
    }
}
