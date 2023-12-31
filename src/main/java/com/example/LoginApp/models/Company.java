package com.example.LoginApp.models;

import com.example.LoginApp.DateAudit.DateAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EnableJpaAuditing
public class Company extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String slug;
    private String description;

    @Builder.Default
    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private Set<User> users = new HashSet<>();

    // Kshu sic eshte nuk eshte foreign_key fare. eshte thjesht nji vler int kot.e shoh. njs per mom te shof fe iher prit.
    @Column(name = "manager_id", nullable = false, columnDefinition = "int default 0")
    private int manager_id;

    @JsonIgnore
    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj
    private Set<Employee> employees;

    @JsonIgnore
    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj ku?ne hene
    private Set<Project> projects;

    @JsonIgnore
    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj
    private Set<Vacancy> vacancies;

    @JsonIgnore
    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj
    private Set<Interview> interview;

    public void addEmployee(User user) {
        users.add(user);
    }
}
