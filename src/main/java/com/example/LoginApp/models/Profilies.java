package com.example.LoginApp.models;

import com.example.LoginApp.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profilies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
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
