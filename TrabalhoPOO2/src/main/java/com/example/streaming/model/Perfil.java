package com.example.streaming.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "perfil")
public class Perfil {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomePerfil;

    @ManyToOne
    private Usuario usuario;

    @OneToMany(mappedBy = "perfil")
    private List<Visualizacao> visualizacoes = new ArrayList<>();

    @OneToMany(mappedBy = "perfil")
    private List<Avaliacao> avaliacoes = new ArrayList<>();
}
