package com.example.demo.game;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repository;

    public void save(final Player student) {
        repository.save(student);
    }

    public List<Player> getAll() {
        final List<Player> players = new ArrayList<>();
        repository.findAll().forEach(players::add);
        return players;
    }

    public void update(int id){

    }

}
