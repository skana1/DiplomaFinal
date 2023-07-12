package com.example.LoginApp.models;

import com.example.LoginApp.DateAudit.DateAudit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EnableJpaAuditing
public class Interview extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne()
    private Company company;
    //private int company_id;

    @ManyToOne()
    private Profile profiles;

    //private int profile_id;

    private Date data;
    private Date time;
    private int duration;
    private String title;
    private String notes;

    @ManyToOne()
    private Vacancy vacancy;
    //private int vacant_id;

}
