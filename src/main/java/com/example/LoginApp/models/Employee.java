package com.example.LoginApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
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
    private Set<Tasks> tasks;


    @OneToOne(mappedBy = "employee")
    private Profiles profiles;

    //private int profile_id;

    @Column(nullable = true)
    private Date ending_date;

}
