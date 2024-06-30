package com.example.demo.entities;

import java.util.List;

public class Playlists {
    private final Long id;
    private final String name;
    private final List<Song> songs;

    public Playlists(Long id, String name, List<Song> songs) {
        this.id = id;
        this.name = name;
        this.songs = songs;
    }

    public Playlists(String name, List<Song> songs) {
        this.name = name;
        this.id = null;
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song){
        this.songs.add(song);
    }
    
    public void deleteSong(Song song){
        this.songs.remove(song);
    }

    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }
}
