package com.example.LoginApp.repository;

import com.example.LoginApp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findEmployeeById(Integer id);

    void deleteEmployeeById(Integer id);
}
