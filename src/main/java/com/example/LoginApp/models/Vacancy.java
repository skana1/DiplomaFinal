package com.example.LoginApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne()
    private Company company;
    //private int company_id;

    private String position;
    private int min_salary;
    private int max_salary;
    private String description;

    @OneToMany(mappedBy = "vacancy") // duhet emri i kolones te tabela tj
    private Set<Application> applications;

    @OneToMany(mappedBy = "vacancy") // duhet emri i kolones te tabela tj
    private Set<Interview> interview;


}
