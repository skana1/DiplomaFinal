package com.example.LoginApp.service;

import com.example.LoginApp.exception.CompanyNotFoundException;
import com.example.LoginApp.models.Company;
import com.example.LoginApp.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;



    public Company createCompany(Company company){
        return companyRepository.save(company);
    }

    public List<Company> findCompany() {
        return companyRepository.findAll();
    }

    public Company findCompanyById(Integer id) {
        return companyRepository.findCompanyById(id).orElseThrow(() ->
                new CompanyNotFoundException("Company by Id: " + id + " was not found"));


    }

    public Company updateCompany(Company company) {
        Optional<Company> existingCompany = companyRepository.findById(company.getId());
        if (existingCompany.isPresent()) {
            Company updatedCompany = existingCompany.get();
            updatedCompany.setName(company.getName());
            updatedCompany.setSlug(company.getSlug());
            updatedCompany.setDescription(company.getDescription());

            return companyRepository.save(updatedCompany);
        } else {
            throw new CompanyNotFoundException("Company not found with ID: " + company.getId());
        }
    }

    @Transactional
    public void deleteById(Integer id) {
        companyRepository.deleteCompanyById(id);
    }
}
