package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlists;
import com.example.demo.entities.Song;
import com.example.demo.services.PlaylistService;

public class DeleteSongFromPlaylist implements ICommand {
    private final PlaylistService playlistService;

    public DeleteSongFromPlaylist(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    private void printSong(List<Song> list){
        System.out.print("[");
        for(int i = 0; i<list.size(); i++){
            System.out.print(list.get(i).toString());
            if(i != list.size()-1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    @Override
    public void invoke(List<String> token){
        Playlists p = playlistService.deleteSongFromPlaylist(token.get(1),Long.parseLong(token.get(2)));
        System.out.print("Playlist " + p.getName() + " is revised with ");
        printSong(p.getSongs());
    }
}
