package com.example.demo;

import com.example.demo.services.PlayerService;

public class PauseState extends PlayerState {

    public PauseState(PlayerService playerService) {
        super(playerService);
    }

    @Override
    public void play(){
        player.setCurrentState(new PlayState(player));
    }

    @Override
    public void next(){
        play();
    }

    @Override
    public void previous(){
        play();
    }

    @Override
    public void stop(){
        player.setCurrentState(new IdleState(player));
    }
    
    
}