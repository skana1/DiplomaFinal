package com.example.LoginApp.models;

import com.example.LoginApp.DateAudit;
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
public class Vacancy extends DateAudit {

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
