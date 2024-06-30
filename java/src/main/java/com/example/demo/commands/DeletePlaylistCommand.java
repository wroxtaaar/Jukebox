package com.example.demo.commands;
import java.util.List;
import com.example.demo.entities.Playlists;
import com.example.demo.services.PlaylistService;

public class DeletePlaylistCommand implements ICommand {
    private final PlaylistService playlistService;

    public DeletePlaylistCommand (PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    public void invoke(List<String> token){
        Playlists p = playlistService.deletPlaylists(token.get(1));
        System.out.println("Playlist " + p.getName() + " is deleted!");
    }
}
