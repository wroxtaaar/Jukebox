package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayerService;

public class NextSongCommand implements ICommand {
    private final PlayerService playerService;

    public NextSongCommand (PlayerService playerService) {
        this.playerService = playerService;
    }

    public void invoke(List<String> token){
        Song s = playerService.NextSong();
        System.out.println(s.toString() + " is playing!");
    }
    
}
