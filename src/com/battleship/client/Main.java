package com.battleship.client;

import com.battleship.controller.BattleshipGame;

import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BattleshipGame game = new BattleshipGame();
        game.startGame();
    }
}