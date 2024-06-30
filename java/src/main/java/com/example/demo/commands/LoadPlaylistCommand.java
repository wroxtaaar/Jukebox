package com.example.demo.commands;


import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Playlists;
import com.example.demo.services.PlayerService;

public class LoadPlaylistCommand implements ICommand {

    private final PlayerService playerService;

    public LoadPlaylistCommand(PlayerService playerService) {
        this.playerService = playerService;
    }



    @Override
    public void invoke(List<String> token) {
        String playListName = token.get(1);
        Optional<Playlists> playlist = playerService.loadSongs(playListName);
        if(playlist.isPresent()){
            System.out.println("Playlist " + playlist.get().getName() + " is loaded!");
        }
        else{
            System.out.println("Playlist " + playListName + " not found");
        }
        
    }
}
