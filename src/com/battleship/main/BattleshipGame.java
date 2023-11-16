package com.battleship.main;
import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard;
import com.battleship.player.Player;
import com.battleship.ship.Ship;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleshipGame {

    private final Player player;
    private final boolean gameOver = ShipBoard.allShipsSunk();

    public BattleshipGame() {

        player = new Player();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        player.placeShips(); // Player places their ships

        while (!gameOver) {
            String impact = player.takeTurn(); // Player takes a turn to fire

        }

        System.out.println("Game Over! All ships have been sunk.");
        scanner.close(); // Close scanner
    }
}