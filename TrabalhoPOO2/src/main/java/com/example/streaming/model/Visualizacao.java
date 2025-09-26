package com.example.streaming.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "visualizacao")
public class Visualizacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne private Perfil perfil;
    @ManyToOne private Video video;

    private LocalDateTime dataHora;
    private Integer progresso;
}
