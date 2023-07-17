package com.example.LoginApp.authenticate;

import com.example.LoginApp.DateAudit.DateAudit;
import com.example.LoginApp.enumerate.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeCreateRequest extends DateAudit {

    private int company_id;
    private String position;
    private Date starting_date;
    private int salary;
    private boolean insurance;
    private String contract_type;
    private int task_id;
    private int profile_id;
    private Date ending_date;

    private String full_name;
    private String email;
    private Long phone_number;
    private Date dob;
    private String country;
    private String city;
    private String address;
    private Gender gender;
    private String experience;

}
