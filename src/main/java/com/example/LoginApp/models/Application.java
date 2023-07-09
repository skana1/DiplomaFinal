package com.example.LoginApp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne()
    private Vacancy vacancy;
   //private int vacant_id;

    @ManyToOne()
    private Profiles profiles;
    //private int profile_id;

}
