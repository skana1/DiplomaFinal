package com.example.LoginApp.models;

import com.example.LoginApp.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private int project_id;

    @ManyToOne()
    private Employee employee;

    @ManyToOne()
    private Project projects;

    //private int employee_id;

    private int level;
    private String name;
    private String description;
    private Status status;


}
