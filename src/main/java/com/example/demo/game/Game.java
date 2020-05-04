package com.example.demo.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> playerList;

    /**
     * constructor in care instantiem un joc
     */
    public Game(){
        playerList=new ArrayList<>();
    }

    /**
     * adaugam un player in lista de playeri
     * @param player
     */
    public void addPlayer(Player player){
        playerList.add(player);
    }

    /**
     * getter
     * @return
     */
    public List<Player> getPlayerList() {
        return playerList;
    }

    /**
     * setter
     * @param playerList
     */
    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    /**
     * stergem un player din lista de playeri
     * @param player
     */
    public void removePlayer(Player player){
        if (playerList.indexOf(player)==-1)
            return;
        playerList.remove(player);
    }

    /**
     * cautam un player dupa id
     * @param id
     * @return
     */
    public Player findById(int id){
        return playerList.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
