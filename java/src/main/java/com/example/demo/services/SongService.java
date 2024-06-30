package com.example.demo.services;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.repositories.ISongRepository;

public class SongService {

    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song addSong(String name, String album,String genre, String artist){
        Song song = new Song(name,artist,album,genre);
        return songRepository.save(song);
    }

    public List<Song> listSong(){
        return songRepository.findAll();
    }
    
}
