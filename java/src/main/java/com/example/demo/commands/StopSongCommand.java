package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayerService;

public class StopSongCommand implements ICommand {
    private final PlayerService playerService;

    public StopSongCommand (PlayerService playerService) {
        this.playerService = playerService;
    }

    public void invoke(List<String> token){
        Song s = playerService.StopSong();
        System.out.println(s.toString() + " is stopped!");
    }
}
