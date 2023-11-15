package com.battleship.main;

import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard;
import com.battleship.player.Player;

import java.util.Scanner;

public class BattleshipGame {
    private static final int BOARD_SIZE = 10; // size of the game board
    private static final int SHIP_COUNT = 5; // total number of ships placed on the board
    private ShipBoard playerBoard; // manages players ships
    private FiringBoard firingBoard; // manages firing attempts
    private Player player;
    private boolean gameOver = false;

    public BattleshipGame() {
        playerBoard = new ShipBoard(BOARD_SIZE);
        firingBoard = new FiringBoard(BOARD_SIZE);
        player = new Player();
        // TODO: place ships (each player sets their respective ships)
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        player.placeShips(scanner, playerBoard); // players can place their ships
        while (!gameOver) {
            /* TODO: implement firingBoard and shipBoard for players take turns firing at each other's ships,
             * update gameOver based whether all ships are sunk or not
             * Player chooses a target.
             * Check for hit or miss.
             * Update firingBoard and playerBoard.
             * Check if all ships are sunk or update gameOver.
             */
            // player fires a shot
            boolean hit = player.takeTurn(scanner, playerBoard, firingBoard); //TODO: placeholder for method in Player()
            if (hit) {
                System.out.println("Hit!");
            }
            else {
                System.out.println("Miss!");
            }
            // check if game is over (all ships sunk)
            gameOver = playerBoard.allShipsSunk(); // TODO: change placeholder for actual method in shipBoard()
            firingBoard.printBoard(); // TODO: add printBoard method to firingBoard to display current state of firing board
        }

        System.out.println("Game Over! All ships have been sunk.");
        scanner.close();
    }

    public static void main(String[] args) {
        new BattleshipGame().startGame(); // starts the game
    }
}