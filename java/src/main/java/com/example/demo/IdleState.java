package com.example.demo;

import com.example.demo.services.PlayerService;

public class IdleState extends PlayerState {

    public IdleState(PlayerService playerService) {
        super(playerService);
    }

    @Override
    public void play(){
        player.setCurrentState(new PlayState(player));
    }
    
}
