package com.example.LoginApp.models;

import com.example.LoginApp.DateAudit.DateAudit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

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

    @OneToMany(mappedBy = "company")
    private Set<User> users;

    // Kshu sic eshte nuk eshte foreign_key fare. eshte thjesht nji vler int kot.e shoh. njs per mom te shof fe iher prit.
    @Column(name = "manager_id", nullable = false, columnDefinition = "int default 0")
    private int manager_id;

    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj
    private Set<Employee> employees;

    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj ku?ne hene
    private Set<Project> projects;

    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj
    private Set<Vacancy> vacancies;

    @OneToMany(mappedBy = "company") // duhet emri i kolones te tabela tj
    private Set<Interview> interview;
}
