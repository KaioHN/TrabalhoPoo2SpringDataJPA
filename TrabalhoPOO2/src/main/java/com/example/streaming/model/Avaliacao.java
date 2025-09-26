package com.example.streaming.model;

import jakarta.persistence.*;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne private Perfil perfil;
    @ManyToOne private Video video;

    private Integer nota;
    private String comentario;
}
