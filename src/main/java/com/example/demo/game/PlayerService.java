package com.example.demo.game;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository repository;

    /**
     * adauga in baza de date un player
     * @param student
     */
    public void save(final Player student) {
        repository.save(student);
    }

    /**
     * returneaza toti playerii din baza de date
     * @return
     */
    public List<Player> getAll() {
        final List<Player> players = new ArrayList<>();
        repository.findAll().forEach(players::add);
        return players;
    }


}
