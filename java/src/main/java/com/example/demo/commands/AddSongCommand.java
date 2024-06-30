package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

public class AddSongCommand implements ICommand{
    private final SongService songService;

    public AddSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> token){
        Song s = songService.addSong(token.get(1),token.get(2),token.get(3), token.get(4));
        System.out.println(s.toString());
    }
}
