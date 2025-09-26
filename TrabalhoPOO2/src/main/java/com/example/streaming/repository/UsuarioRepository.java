package com.example.streaming.repository;

import com.example.streaming.model.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Visualizacao vis JOIN vis.perfil p JOIN p.usuario u GROUP BY u ORDER BY COUNT(vis) DESC")
    List<Usuario> findTopWatchers(Pageable pageable);
}
