package com.example.demo.commands;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Playlists;
import com.example.demo.services.PlaylistService;

public class CreatePlaylistCommand implements ICommand{
    
    private final PlaylistService playlistService;

    public CreatePlaylistCommand(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }


    private List<Long> getListOfSongId(List<String> token){
        List<Long> songId = new ArrayList<>();
        for(int i = 2; i<token.size(); i++){
            songId.add(Long.parseLong(token.get(i)));
        }
        return songId;
    }


    @Override
    public void invoke(List<String> token){
        Playlists p = playlistService.addPlaylists(token.get(1),getListOfSongId(token));
        System.out.println(p.toString());
    }
}
