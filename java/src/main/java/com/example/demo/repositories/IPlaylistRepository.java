package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Playlists;

public interface IPlaylistRepository {
    Playlists save(Playlists song);
    Optional<Playlists> findById(Long id);
    List<Playlists> findAll();
    boolean existsById(Long id);
    long count();
    void deleteById(Long id);
}