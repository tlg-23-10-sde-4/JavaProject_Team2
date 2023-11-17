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

    public BattleshipGame() {
        player1 = new Player();
        player2 = new Player();
    }

    public void startGame() {
        placeShipsForPlayers();
        playRounds();
    }

    // ship placement management
    private void placeShipsForPlayers() {
        System.out.println("Player 1, place your ships:");
        player1.placeShips(new ShipBoard());

        System.out.println("Player 2, place your ships:");
        player2.placeShips(new ShipBoard());
    }

    // game round management
    private void playRounds() {
        while (true) { // alternate turns until a 'player' loses
            System.out.println("Player 1's turn to fire:");
            takeTurn();
            if (player2.hasLost()) {
                System.out.println("Player 1 wins!");
                break;
            }

            takeTurn();
            if (player1.hasLost()) {
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }

    // player turn management
    private void takeTurn(Player currentPlayer, Player opponent) {
        System.out.println("Player's turn to fire: ");
        String guess = currentPlayer.takeTurn();

        // display current board
        currentPlayer.getFiringBoard().printBoard();
        opponent.getShipBoard().printBoard();

        if (opponent.hasLost()) { // checks for end of game
            System.out.println("Player has won the game!");
        }
    }

    // main method
    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.startGame();
    }
}