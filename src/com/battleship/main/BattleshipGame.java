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
        player1 = new Player(new ShipBoard(), new FiringBoard()); // TODO: update constructor in Player
        player2 = new Player(new ShipBoard(), new FiringBoard());
    }

    public void startGame() {
        placeShipsForPlayers();
        playRounds();
    }

    // ship placement management
    private void placeShipsForPlayers() {
        System.out.println("Player 1, place your ships:");
        player1.placeShips(player1.getShipBoard()); // TODO: getShipBoard() implement method in Player

        System.out.println("Player 2, place your ships:");
        player2.placeShips(player2.getShipBoard());
    }

    // game round management
    private void playRounds() {
        while (!player1.getShipBoard().allShipsSunk() && !player2.getShipBoard().allShipsSunk()) { // alternate turns until a 'player' loses
            System.out.println("Player 1's turn to fire:");
            takeTurn(player1, player2);
            if (player2.getShipBoard().allShipsSunk()) {
                System.out.println("Player 1 wins!");
                break;
            }

            takeTurn(player2, player1);
            if (player1.getShipBoard().allShipsSunk()) {
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }

    // player turn management
    private void takeTurn(Player currentPlayer, Player opponent) {
        System.out.println(currentPlayer.getName() + "Player's turn to fire: "); // TODO: implement getName() in Player
        String guess = currentPlayer.takeTurn();

        // TODO: handle what happens when player makes guess

        // display boards
        currentPlayer.getFiringBoard().printBoard(); // TODO: implement getFiringBoard() in Player
        opponent.getShipBoard().printBoard();

        // check if opponent lost
        if (opponent.getShipBoard().allShipsSunk()) {
            System.out.println(currentPlayer.getName() + " has won the game!");
        }
    }

    // main method
    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.startGame();
    }
}