package com.example.demo.services;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
import com.example.demo.IdleState;
import com.example.demo.PauseState;
import com.example.demo.PlayState;
import com.example.demo.PlayerState;
import com.example.demo.entities.Playlists;
import com.example.demo.entities.Song;


public class PlayerService{
    private final PlaylistService playlistService;
    private PlayerState currentState;
    private Deque<Song> player;


    public PlayerService(PlaylistService playlistService) {
        this.playlistService = playlistService;
        this.currentState = new IdleState(this);
        player = new ArrayDeque<>();
    }


    public Optional<Playlists> loadSongs(String playlistsName){
        unLoadSongs();
        Optional<Playlists> playlists = playlistService.getPlayListByName(playlistsName);
        if(playlists.isPresent()){
        List<Song> songsList = playlists.get().getSongs();
        for(Song s : songsList){
            player.offer(s);
           }
        }
        return playlists;
    }

    public void unLoadSongs(){
        player.clear();
    }


    public void setCurrentState(PlayerState playerState){
        currentState = playerState;
    }



    public void PlaySong(){
        currentState.play();
        if(currentState instanceof PlayState) System.out.println(player.peekFirst().toString() + " is playing!");
        else if(currentState instanceof PauseState) System.out.println(player.peekFirst().toString() + " is paused!");
    }

    public Song NextSong(){
        currentState.next();
        player.addLast(player.removeFirst());
        return player.peekFirst();
    }

    public Song PreviousSong(){
        currentState.previous();
        player.addFirst(player.removeLast());
        return player.peekFirst();
    }
    
    public Song StopSong(){
        currentState.stop();
        return player.peekFirst();
    }
}