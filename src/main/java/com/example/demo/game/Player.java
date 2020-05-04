package com.example.demo.game;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {
    @Id
    @GeneratedValue
    int id;
    String name;

    public Player(){

    }

    /**
     * constructor in care instantiem id-ul si numele
     * @param id
     * @param name
     */
    public Player(int id, String name) {
        this.id=id;
        this.name=name;
    }

    /**
     * getter
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * setter
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
}
