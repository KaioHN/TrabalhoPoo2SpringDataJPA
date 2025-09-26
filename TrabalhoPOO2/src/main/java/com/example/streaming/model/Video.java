package com.example.streaming.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "video")
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private Integer duracao;

    @ManyToOne
    private Categoria categoria;

    @OneToMany(mappedBy = "video")
    private List<Visualizacao> visualizacoes = new ArrayList<>();

    @OneToMany(mappedBy = "video")
    private List<Avaliacao> avaliacoes = new ArrayList<>();
}
