package com.battleship.main;
import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard;
import com.battleship.player.Player;
import com.battleship.ship.Ship;

import java.util.ArrayList;
import java.util.Scanner;

public class BattleshipGame {
    private Player player1;
    private Player player2;
    private Scanner scanner;

    public void BattleshipGame() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        placeShipsForPlayers();
        playRounds();
    }

    // ship placement management
    private void placeShipsForPlayers() {
        System.out.println("Player 1, place your ships:");
        player1.placeShips(scanner); // scanner used to read user input from the console
        player1.getShipBoard().printBoard(); // TODO: implement printBoard() method in ShipBoard()

        System.out.println("Player 2, place your ships:");
        player2.placeShips(scanner);
        player2.getShipBoard().printBoard(); // TODO: implement printBoard() method in FiringBoard()
    }

    // game round management
    private void playRounds() {
        while (!player1.hasLost() && !player2.hasLost()) { // alternate turns until a 'player' loses
            System.out.println("Player 1's turn to fire:");
            player1.takeTurn(scanner);
            if (player2.hasLost()) {
                System.out.println("Player 1 wins!");
                break;
            }

            if (player1.hasLost()) {
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }

    // player turn management
    private void takeTurn(Player currentPlayer, Player opponent) {
        System.out.println(currentPlayer.getFleetName() + " 's turn to fire:");
        currentPlayer.takeTurn(scanner);
        opponent.getShipBoard().printBoard(); // shows the opponent board after the shot
    }

    // main method
    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.startGame();
    }
}