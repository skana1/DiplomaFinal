package com.example.LoginApp.controller;

import com.example.LoginApp.authenticate.VacancyCreateRequest;
import com.example.LoginApp.models.Vacancy;
import com.example.LoginApp.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vacancy")
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;

    @GetMapping("/all")
    public ResponseEntity<List<Vacancy>> getAllVacancies(){
        List<Vacancy> vacancyList = vacancyService.getAllVacancies();
        return new ResponseEntity<>(vacancyList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Vacancy> findVacancyById(@PathVariable("id") Integer id){
        Vacancy vacancy = vacancyService.findVacancyById(id);
        return new ResponseEntity<>(vacancy, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Vacancy> createVacancy(@RequestBody VacancyCreateRequest vacancy){
        Vacancy newVacancy = vacancyService.createVacancy(vacancy);
        return new ResponseEntity<>(newVacancy, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vacancy> updateVacancy(@RequestBody Vacancy vacancy){
        Vacancy updatedVacancy = vacancyService.updateVacancy(vacancy);
        return new ResponseEntity<>(updatedVacancy, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Vacancy> deleteVacancy(@PathVariable("id") Integer id){
        vacancyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
