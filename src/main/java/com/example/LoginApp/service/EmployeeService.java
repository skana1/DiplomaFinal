package com.example.LoginApp.service;

import com.example.LoginApp.exception.ApplicationNotFoundException;
import com.example.LoginApp.exception.EmplyeeNotFoundException;
import com.example.LoginApp.models.Employee;
import com.example.LoginApp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
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
