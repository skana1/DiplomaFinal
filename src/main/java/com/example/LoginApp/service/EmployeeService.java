package com.example.LoginApp.service;

import com.example.LoginApp.authenticate.EmployeeCreateRequest;
import com.example.LoginApp.exception.EmplyeeNotFoundException;
import com.example.LoginApp.models.Company;
import com.example.LoginApp.models.Employee;
import com.example.LoginApp.models.Profile;
import com.example.LoginApp.models.Task;
import com.example.LoginApp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final CompanyService companyService;
    private final ProfileService profileService;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(EmployeeCreateRequest employee) {
        Profile profile = Profile.builder()
                .address(employee.getAddress())
                .city(employee.getCity())
                .country(employee.getCountry())
                .dob(employee.getDob())
                .full_name(employee.getFull_name())
                .email(employee.getEmail())
                .phone_number(employee.getPhone_number())
                .gender(employee.getGender())
                .experience(employee.getExperience())
                .build();

        Profile builtProfile = profileService.createProfile(profile);

        Company company = companyService.findCompanyById(employee.getCompany_id());

        Employee buildEmployee = Employee.builder()
                .company(company)
                .profile(profile)
                .position(employee.getPosition())
                .starting_date(employee.getStarting_date())
                .contract_type(employee.getContract_type())
                .salary(employee.getSalary())
                .insurance(employee.isInsurance())
                .build();
        return employeeRepository.save(buildEmployee);
    }

    public Employee findEmployeeById(Integer id) {
       return employeeRepository.findEmployeeById(id).orElseThrow(() ->
               new EmplyeeNotFoundException("Employee by Id: " + id + " was not found"));
    }

    public Employee updateEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employee.getId());

        if(existingEmployee.isPresent()){
            Employee updatedEmployee = existingEmployee.get();
            updatedEmployee.setCompany(employee.getCompany());
            updatedEmployee.setContract_type(employee.getContract_type());
            updatedEmployee.setStarting_date(employee.getStarting_date());
            updatedEmployee.setEnding_date(employee.getEnding_date());
            updatedEmployee.setInsurance(employee.isInsurance()); // Use the 'isInsurance' getter for boolean values
            updatedEmployee.setPosition(employee.getPosition());
            updatedEmployee.setProfile(employee.getProfile());
            updatedEmployee.setTasks(employee.getTasks());
            updatedEmployee.setSalary(employee.getSalary()); // Corrected method name


            return employeeRepository.save(updatedEmployee);
        } else {
            throw new EmplyeeNotFoundException("Employee by Id: " + employee.getId() + " was not found");
        }
    }

    @Transactional
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteEmployeeById(id);
    }
}
