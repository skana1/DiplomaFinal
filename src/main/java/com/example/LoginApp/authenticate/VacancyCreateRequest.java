package com.example.LoginApp.authenticate;

import com.example.LoginApp.enumerate.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacancyCreateRequest {
    private String position;
    private int min_salary;
    private int max_salary;
    private String description;
    private int company_id;
}
