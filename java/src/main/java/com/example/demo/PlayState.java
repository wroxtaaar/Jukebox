package com.example.demo;

import com.example.demo.services.PlayerService;

public class PlayState extends PlayerState {

    public PlayState(PlayerService playerService) {
        super(playerService);
    }

    @Override
    public void play(){
        player.setCurrentState(new PauseState(player));
    }

    @Override
    public void next(){

    }

    @Override
    public void previous(){

    }

    @Override
    public void stop(){
        player.setCurrentState(new PauseState(player));
    }
    
}