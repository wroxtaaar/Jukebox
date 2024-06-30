package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Song;
import com.example.demo.services.SongService;

public class ListSongCommand implements ICommand{

    private final SongService songService;


    public ListSongCommand(SongService songService) {
        this.songService = songService;
    }

    @Override
    public void invoke(List<String> token){
        List<Song> allSong = songService.listSong();
        printSong(allSong);

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
}
