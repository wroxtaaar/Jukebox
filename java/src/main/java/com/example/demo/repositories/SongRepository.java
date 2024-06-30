package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Song;

public class SongRepository implements ISongRepository {

    private final Map<Long,Song> songMap;
    private Long autoIncrement = 1L;

    public SongRepository() {
        songMap = new HashMap<Long,Song>();
    }

    public Song save(Song song){
        Song s = new Song(autoIncrement,song.getName(),song.getArtist(), song.getAlbum(), song.getGenre());
        songMap.put(autoIncrement,s);
        autoIncrement++;
        return s;
        
    }
    public Optional<Song> findById(Long id){
        return Optional.ofNullable(songMap.get(id));
    }
    public List<Song> findAll(){
        return songMap.values().stream().collect(Collectors.toList());
    }
    
    public boolean existsById(Long id){
        return songMap.containsKey(id);
    }

    public long count(){
        return songMap.size();
    }
    public void deleteById(Long id){
        songMap.remove(id);
    }
}
