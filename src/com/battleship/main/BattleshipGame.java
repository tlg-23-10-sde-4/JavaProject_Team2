package com.battleship.main;
import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard;
import com.battleship.player.Player;
import com.battleship.ship.Ship;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleshipGame {
    private final Player player1;
    private final Player player2;
    private final ShipBoard player1Shipboard = new ShipBoard();
    private final ShipBoard player2Shipboard = new ShipBoard();
    private final FiringBoard player1FiringBoard = new FiringBoard();
    private final FiringBoard player2FiringBoard = new FiringBoard();


    public BattleshipGame() {
        player1 = new Player(); // TODO: update constructor in Player
        player2 = new Player();
    }

    public void startGame() {
        placeShipsForPlayers();
        playRounds();
    }

    // ship placement management
    private void placeShipsForPlayers() {
        System.out.println("Player 1, place your ships:");
        player1.placeShips(player1Shipboard); // TODO: getShipBoard() implement method in Player

        System.out.println("Player 2, place your ships:");
        player2.placeShips(player2Shipboard);
    }

    // game round management
    private void playRounds() {
        while (!player1Shipboard.allShipsSunk() && !player2Shipboard.allShipsSunk()) { // alternate turns until a 'player' loses
            System.out.println("Player 1's turn to fire:");
            takeTurn(player1, player2);
            if (player2Shipboard.allShipsSunk()) {
                System.out.println("Player 1 wins!");
                break;
            }

            takeTurn(player2, player1);
            if (player1Shipboard.allShipsSunk()) {
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }

    // player turn management
    private void takeTurn(Player player1, Player player2) {
        System.out.println(player1.getClass().getName() + " Player's turn to fire: "); // TODO: implement getName() in Player
        String guess = player1.takeTurn();

        // TODO: handle what happens when player makes guess

        // display boards
        player1FiringBoard.printBoard(); // TODO: implement getFiringBoard() in Player
        player2Shipboard.printBoard();

        // check if opponent lost
        if (player2Shipboard.allShipsSunk()) {
            System.out.println(player1.getClass().getName() + " has won the game!");
        }
    }

    // main method
    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.startGame();
    }
}