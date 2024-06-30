package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.PlayerService;

public class PreviousSongCommand implements ICommand {
    private final PlayerService playerService;

    public PreviousSongCommand (PlayerService playerService) {
        this.playerService = playerService;
    }

    public void invoke(List<String> token){
        Song s = playerService.PreviousSong();
        System.out.println(s.toString() + " is playing!");
    }
}
