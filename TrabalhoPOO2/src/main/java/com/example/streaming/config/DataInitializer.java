package com.example.streaming.config;

import com.example.streaming.model.*;
import com.example.streaming.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(UsuarioRepository usuarioRepo,
                               PerfilRepository perfilRepo,
                               CategoriaRepository categoriaRepo,
                               VideoRepository videoRepo,
                               VisualizacaoRepository visRepo,
                               AvaliacaoRepository avalRepo) {
        return args -> {
            Categoria catA = new Categoria(); catA.setNome("Ação"); categoriaRepo.save(catA);
            Categoria catC = new Categoria(); catC.setNome("Missões"); categoriaRepo.save(catC);

            Usuario u1 = new Usuario(); u1.setNome("Carlos"); u1.setEmail("carlos@example.com");
            u1.setSenha("123"); u1.setDataCadastro(LocalDateTime.now()); usuarioRepo.save(u1);

            Perfil p1 = new Perfil(); p1.setNomePerfil("PerfilCarlos"); p1.setUsuario(u1); perfilRepo.save(p1);

            Video v1 = new Video(); v1.setTitulo("Missão Resgate"); v1.setDescricao("Um resgate épico");
            v1.setDuracao(1200); v1.setCategoria(catC); videoRepo.save(v1);

            Avaliacao a1 = new Avaliacao(); a1.setPerfil(p1); a1.setVideo(v1); a1.setNota(5); avalRepo.save(a1);

            Visualizacao vis = new Visualizacao(); vis.setPerfil(p1); vis.setVideo(v1);
            vis.setDataHora(LocalDateTime.now()); vis.setProgresso(100); visRepo.save(vis);

            System.out.println("Dados iniciais carregados!");
        };
    }
}
