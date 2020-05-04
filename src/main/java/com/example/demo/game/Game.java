package com.example.demo.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playerList;
    public Game(){
        playerList=new ArrayList<>();
    }
    public void addPlayer(Player player){
        playerList.add(player);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void removePlayer(Player player){
        if (playerList.indexOf(player)==-1)
            return;
        playerList.remove(player);
    }

    public Player findById(int id){
        return playerList.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
