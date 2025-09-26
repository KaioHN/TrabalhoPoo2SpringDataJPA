package com.example.streaming.service;

import com.example.streaming.model.Usuario;
import com.example.streaming.model.Video;
import com.example.streaming.repository.UsuarioRepository;
import com.example.streaming.repository.VideoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreamingQueriesService {
    private final VideoRepository videoRepo;
    private final UsuarioRepository usuarioRepo;

    public StreamingQueriesService(VideoRepository videoRepo, UsuarioRepository usuarioRepo) {
        this.videoRepo = videoRepo;
        this.usuarioRepo = usuarioRepo;
    }

    public List<Video> buscarPorTitulo(String termo) {
        return videoRepo.findByTituloContainingIgnoreCaseOrderByTituloAsc(termo);
    }

    public List<Video> videosPorCategoria(String nomeCategoria) {
        return videoRepo.findByCategoriaNomeOrderByTituloAsc(nomeCategoria);
    }

    public List<Video> top10MaisBemAvaliados() {
        Pageable top10 = PageRequest.of(0, 10);
        return videoRepo.findTopRated(top10);
    }

    public List<Video> top10MaisAssistidos() {
        Pageable top10 = PageRequest.of(0, 10);
        return videoRepo.findTopWatched(top10);
    }

    public Usuario usuarioQueMaisAssistiu() {
        Pageable top1 = PageRequest.of(0, 1);
        List<Usuario> top = usuarioRepo.findTopWatchers(top1);
        return top.isEmpty() ? null : top.get(0);
    }
}
