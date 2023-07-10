package com.example.LoginApp.models;

import com.example.LoginApp.DateAudit;
import com.example.LoginApp.enumerate.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EnableJpaAuditing
public class Profile extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToMany(mappedBy = "profiles") // duhet emri i kolones te tabela tj
    private Set<Application> applications;

    @OneToMany(mappedBy = "profiles")
    private Set<Skill> skills;

    @OneToOne(mappedBy = "profile")
    private Employee employee;

    @OneToMany(mappedBy = "profiles")
    private Set<Interview> interview;

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
