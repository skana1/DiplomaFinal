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
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String slug;
    private String description;

    @OneToMany(mappedBy = "company")
    private Set<Users> users;

    @Column(name = "manager_id", nullable = false, columnDefinition = "int default 0")
    private int manager_id;

    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj
    private Set<Employee> employees;

    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj
    private Set<Projects> projects;

    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj
    private Set<Vacancies> vacancies;

    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj
    private Set<Interview> interview;
}
