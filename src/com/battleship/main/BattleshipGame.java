package com.battleship.main;
import com.apps.util.Console;
import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard;
import com.battleship.player.Player;

public class BattleshipGame {
    private final Player player1;
    private final Player player2;
    private final ShipBoard player1Shipboard = new ShipBoard();
    private final ShipBoard player2Shipboard = new ShipBoard();
    private final FiringBoard player1FiringBoard = new FiringBoard(player2Shipboard);
    private final FiringBoard player2FiringBoard = new FiringBoard(player1Shipboard);

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
        player1.placeShips(player1Shipboard, player2FiringBoard);
        clearConsole();

        System.out.println("Player 2, place your ships:");
        player2.placeShips(player2Shipboard, player1FiringBoard);
        clearConsole();
    }

    // game round management
    public void playRounds() {
        while (!player1Shipboard.allShipsSunk() && !player2Shipboard.allShipsSunk()) {
            takeTurns(player1, player2);
        }
    }

    // player turn management
    private void takeTurns(Player player1, Player player2) {
        while (!player1Shipboard.allShipsSunk() && !player2Shipboard.allShipsSunk()) {
            System.out.println("Player 1's shipBoard.");
            player1Shipboard.printShipBoard(player2FiringBoard);

            System.out.println("Player 1's firing board: ");
            player1FiringBoard.printFiringBoard();

            System.out.println("Player 1's turn to fire: ");
            player1FiringBoard.fire(player1.takeTurn());

            if (player2Shipboard.sink()) {
                System.out.println("Player 2's ship has been sunk!");
            }

            if (player2Shipboard.allShipsSunk()) {
                System.out.println("Player 1 has won!");
                break;
            }
            clearConsole();

            System.out.println("Player 2's shipBoard.");
            player2Shipboard.printShipBoard(player1FiringBoard);

            System.out.println("Player 2's firing board: ");
            player2FiringBoard.printFiringBoard();

            System.out.println("Player 2's turn to fire: ");
            player2FiringBoard.fire(player2.takeTurn());

            if (player1Shipboard.sink()) {
                System.out.println("Player 1's ship has been sunk!");
            }

            if (player1Shipboard.allShipsSunk()) {
                System.out.println("Player 2 has won!");
                break;
            }
            clearConsole();
        }
    }

    private void clearConsole() {
        Console.clear();
        System.out.println("switching players...");
        Console.pause(3000);
        Console.clear();
    }
}