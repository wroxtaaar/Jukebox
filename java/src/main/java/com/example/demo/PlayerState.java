package com.example.demo;

import com.example.demo.services.PlayerService;

public class PlayerState{
    public PlayerService player;
    public PlayerState(PlayerService playerService) {
        this.player = playerService;
    }

    public void play(){
        System.out.println("Sorry song Cannot be played");
    }

    public void stop(){
        System.out.println("Sorry song Cannot be played");
    }

    public void next(){
        System.out.println("Sorry previous song Cannot be played");
    }

    public void previous(){
        System.out.println("Sorry song Cannot be stopped");
    }

    
    
}
