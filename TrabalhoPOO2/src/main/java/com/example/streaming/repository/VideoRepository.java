package com.example.streaming.repository;

import com.example.streaming.model.Video;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByTituloContainingIgnoreCaseOrderByTituloAsc(String titulo);
    List<Video> findByCategoriaNomeOrderByTituloAsc(String categoriaNome);

    @Query("SELECT v FROM Avaliacao a JOIN a.video v GROUP BY v ORDER BY AVG(a.nota) DESC")
    List<Video> findTopRated(Pageable pageable);

    @Query("SELECT v FROM Visualizacao vis JOIN vis.video v GROUP BY v ORDER BY COUNT(vis) DESC")
    List<Video> findTopWatched(Pageable pageable);
}
