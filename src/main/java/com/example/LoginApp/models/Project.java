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
public class Project extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @OneToMany(mappedBy = "projects") // duhet emri i kolones te tabela tj
    private Set<Task> tasks;

    @ManyToOne()
    private Company company;

    //private int company_id;

    private String name;
    private int duration;
    private String source;

}
