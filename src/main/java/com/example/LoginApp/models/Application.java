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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EnableJpaAuditing
public class Application extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne()
    private Vacancy vacancy;

    @ManyToOne()
    private Profile profiles;


}
