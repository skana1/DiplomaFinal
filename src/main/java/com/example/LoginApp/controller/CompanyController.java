package com.example.LoginApp.controller;


import com.example.LoginApp.service.CompanyService;
import com.example.LoginApp.models.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@RequiredArgsConstructor
public class CompanyController {


    private final CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        Company newCompany =  companyService.createCompany(company);
        return new ResponseEntity<>(newCompany, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompanies (){
        List<Company> companies = companyService.findCompany();
        return new ResponseEntity<>(companies, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Integer id){
        Company company = companyService.findCompanyById(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company){
        Company updateCompany = companyService.updateCompany(company);
        return new ResponseEntity<>(updateCompany, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseEntity> deleteCompany(@PathVariable("id") Integer id){
        companyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




























