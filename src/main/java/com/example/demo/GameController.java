package com.example.demo;


import com.example.demo.game.Game;
import com.example.demo.game.Player;
import com.example.demo.game.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    PlayerService service;

    private static int id=0;
    private final Game game=new Game();

    /**
     * constructor in care initializam 2 playeri
     */
    public GameController(){

    }

    /**
     * returnam lista de playeri
     * @return
     */
    @GetMapping("/players")
    public List<Player> getProducts() {
        return game.getPlayerList();
    }

    /**
     * gets all the players from database
     * @return
     */
    @GetMapping("/players_from_database")
    public List<Player> getProductsFromDatabase() {
        return service.getAll();
    }

    /**
     * numaram toti playerii
     * @return
     */
    @GetMapping("/count")
    public int countProducts() {
        return game.getPlayerList().size();
    }

    /**
     * afisam numai playerul cu id-ul din param
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") int id) {
        return game.findById(id);
    }

    /**
     * adaugam prin post un nou player
     * @param name
     * @return
     */
    @PostMapping
    public int addPlayer(@RequestParam String name){
        Player player=new Player(id++, name);
        game.getPlayerList().add(player);
        service.save(player);
        return player.getId();
    }

    /**
     * adaugam prin post un nou player
     * @param player
     * @return
     */
    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>
    addPlayer(@RequestBody Player player) {
        service.save(player);
        game.getPlayerList().add(player);
        return new ResponseEntity<>(
                "Player created successfully", HttpStatus.CREATED);
    }

    /**
     * modificam prin put playerul cu un anumit id
     * @param id
     * @param name
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlayer(
            @PathVariable int id, @RequestParam String name) {
//        if (id>=game.getPlayerList().size()){
//            return new ResponseEntity<>(
//                    "Player not found", HttpStatus.NOT_FOUND); //or GONE
//        }
        Player player=game.findById(id);
        if (player == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.NOT_FOUND); //or GONE
        }
        player.setName(name);
        return new ResponseEntity<>(
                "Player updated successfully", HttpStatus.OK);
    }

    /**
     * stergem un player cu un anumit id
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable int id) {
        Player player = game.findById(id);
        if (player == null) {
            return new ResponseEntity<>(
                    "Player not found", HttpStatus.GONE);
        }
        game.getPlayerList().remove(player);
        return new ResponseEntity<>("Player removed", HttpStatus.OK);
    }

}
