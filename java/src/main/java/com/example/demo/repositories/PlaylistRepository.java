package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Playlists;


public class PlaylistRepository implements IPlaylistRepository{
    private final Map<Long,Playlists> playlistMap;
    private Long autoIncrement = 1L;

    public PlaylistRepository() {
        playlistMap = new HashMap<Long,Playlists>();
    }

    public Playlists save(Playlists playlist){
        Playlists p = new Playlists(autoIncrement,playlist.getName(),playlist.getSongs()); 
        playlistMap.put(autoIncrement,p);
        autoIncrement++;
        return p;
    }
    public Optional<Playlists> findById(Long id){
        return Optional.ofNullable(playlistMap.get(id));
    }
    public List<Playlists> findAll(){
        return playlistMap.values().stream().collect(Collectors.toList());
    }

    public Optional<Playlists> findByName(String Name){
         for(Playlists p : playlistMap.values()){
            if(p.getName().equals(Name)) return Optional.of(p);
         }
         return Optional.empty();
    }
    
    public boolean existsById(Long id){
        return playlistMap.containsKey(id);
    }

    public long count(){
        return playlistMap.size();
    }
    public void deleteById(Long id){
        playlistMap.remove(id);
    }
}
