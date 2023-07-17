package com.example.LoginApp.models;

import com.example.LoginApp.DateAudit.DateAudit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EnableJpaAuditing
public class Employee extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne()
    private Company company;

    private String position;
    private Date starting_date;
    private int salary;
    private boolean insurance;
    private String contract_type;

    @OneToMany(mappedBy="employee")
    private Set<Task> tasks;

    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    @Column(nullable = true)
    private Date ending_date;

}
