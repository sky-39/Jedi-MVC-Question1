package com.example.gaming;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public void run() {
        if (game != null) {
            game.up();
            game.down();
            game.left();
            game.right();
        } else {
            System.out.println("No game selected to run.");
        }
    }
}
