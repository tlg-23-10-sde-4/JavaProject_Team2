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
    private final Scanner scanner;

    public BattleshipGame() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        System.out.println("Player 1, place your ships:");
        player1.placeShips(scanner);

        System.out.println("Player 2, place your ships:");
        player2.placeShips(scanner);

        while (!player1.hasLost() && !player2.hasLost()) {
            System.out.println("Player 1's turn to fire:");
            player1.takeTurn(scanner);

            if (player2.hasLost()) {
                System.out.println("Player 1 wins!");
                break;
            }

            System.out.println("Player 2's turn to fire:");
            player2.takeTurn(scanner);

            if (player1.hasLost()) {
                System.out.println("Player 2 wins!");
                break;
            }
        }
        scanner.close();
    }

    private void placeShipsForPlayers() {
        System.out.println("Player 1, place your ships:");
        player1.placeShips(scanner);
        player1.getShipBoard().printBoard(); // TODO: implement printBoard() method in ShipBoard()

        System.out.println("Player 2, place your ships:");
        player2.placeShips(scanner);
        player2.getShipBoard().printBoard(); // TODO: implement printBoard() method in FiringBoard()
    }

    private void takeTurn(Player currentPlayer, Player opponent) {
        System.out.println(currentPlayer.getFleetName() + " 's turn to fire:");
        currentPlayer.takeTurn(scanner);
        opponent.getShipBoard().printBoard(); // shows the opponent board after the shot
    }
}