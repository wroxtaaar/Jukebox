package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.PlayerService;

public class PlaySongCommand implements ICommand{
    private final PlayerService playerService;

    public PlaySongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void invoke(List<String> token){
        playerService.PlaySong();
    }
    
}
