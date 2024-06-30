package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Playlists;
import com.example.demo.entities.Song;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.repositories.SongRepository;

public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    private final SongRepository songRepository;

    public PlaylistService(PlaylistRepository playlistRepository,SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    public List<Song> getListOfSongById(List<Long> songs){
        List<Song> songlist = new ArrayList<Song>();
        for(Long id : songs){
            if(songRepository.findById(id).isPresent())
            songlist.add(songRepository.findById(id).get());
        } 
        return songlist;
    }

    public Playlists addSongToPlaylist(String playlistName,Long id){
        Playlists playlists = getPlayListByName(playlistName).get();
        Song song = songRepository.findById(id).get();
        playlists.addSong(song);
        return playlists;
    }

    public Playlists deleteSongFromPlaylist(String playlistName,Long id){
        Playlists playlists = getPlayListByName(playlistName).get();
        Song song = songRepository.findById(id).get();
        playlists.deleteSong(song);
        return playlists;
    }


    public Optional<Playlists> getPlayListByName(String playlistName){
        return playlistRepository.findByName(playlistName);
    }

    public Playlists addPlaylists(String name, List<Long> songs){ 

        Playlists playlist = new Playlists(name, getListOfSongById(songs));
        return playlistRepository.save(playlist);
        
    }

    public Playlists deletPlaylists(String playlistName){
        Playlists playlists = getPlayListByName(playlistName).get();
        playlistRepository.deleteById(playlists.getId());
        return playlists;
    }
    
}
