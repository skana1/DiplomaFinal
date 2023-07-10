package com.example.LoginApp.models;

import com.example.LoginApp.DateAudit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EnableJpaAuditing
public class Skill extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private String name;
    private String grade;

//    private int profile_id;

    @ManyToOne()
    private Profile profiles;
}
