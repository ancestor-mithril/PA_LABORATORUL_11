package com.example.demo;


import com.example.demo.game.Game;
import com.example.demo.game.Player;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    private static int id=0;
    private final Game game=new Game();
    public GameController(){
        game.addPlayer(new Player(id++, "Player1"));
        game.addPlayer(new Player(id++, "Player2"));
    }
    @GetMapping("/players")
    public List<Player> getProducts() {
        return game.getPlayerList();
    }
    @GetMapping("/count")
    public int countProducts() {
        return game.getPlayerList().size();
    }
    @GetMapping("/{id}")
    public Player getPlayer(@PathVariable("id") int id) {
        return game.findById(id);
    }
    @PostMapping
    public int addPlayer(@RequestParam String name){
        game.getPlayerList().add(new Player(id++, name));
        return id;
    }

    @PostMapping(value = "/obj", consumes="application/json")
    public ResponseEntity<String>
    addPlayer(@RequestBody Player player) {
        game.getPlayerList().add(player);
        return new ResponseEntity<>(
                "Product created successfully", HttpStatus.CREATED);
    }

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
