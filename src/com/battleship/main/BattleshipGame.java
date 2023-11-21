package com.battleship.main;

import com.apps.util.Console;
import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard;
import com.battleship.player.CPUPlayer;
import com.battleship.player.Player;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class BattleshipGame {
    private final Player player1;
    private final Player player2;
    private final ShipBoard player1Shipboard = new ShipBoard();
    private final ShipBoard player2Shipboard = new ShipBoard();
    private final FiringBoard player1FiringBoard = new FiringBoard(player2Shipboard);
    private final FiringBoard player2FiringBoard = new FiringBoard(player1Shipboard);
    private boolean isCPUPlaying = false;


    public BattleshipGame() {
        player1 = new Player();
        System.out.println("Will this be a 1 player game? i.e., (true or false)");
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean result = false;
        try {
            choice = scanner.next().trim();
            if (choice.equals("t") || choice.equals("T")) {
                choice = "true";
            }
            if (choice.equals("f") || choice.equals("F")) {
                choice = "false";
            }
            result = Boolean.parseBoolean(choice);
        }
        catch (InputMismatchException e) {
            System.out.println("true or false");
        }
        if (result) {
            player2 = new CPUPlayer();
            isCPUPlaying = true;
        }
        else {
            player2 =new Player();
        }
    }

    // game starts with option to view tutorial first
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to see the tutorial? (yes/no)");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("yes")) {
            showTutorial();
        }
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
            player1FiringBoard.fire(player1.takeTurn(player1FiringBoard, player2Shipboard));

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
            player2FiringBoard.fire(player2.takeTurn(player2FiringBoard, player1Shipboard));

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

    public void showTutorial() {
        System.out.println("Welcome to Admirals Algorithm: Nautical Warfare!");
        System.out.println("-------------------------------");
        System.out.println("Tutorial:");
        System.out.println("1. The game is played on a 10x10 grid, where each player has their own grid.");
        System.out.println("2. Each player places a set of ships on their grid in secret.");
        System.out.println("3. The ships can be placed horizontally or vertically.");
        System.out.println("4. Players take turns to 'fire' at the opponent's grid by calling out grid coordinates (e.g., A5, B6).");
        System.out.println("5. The opponent must announce whether the shot hit or missed. In this game, it's done automatically.");
        System.out.println("6. The goal is to sink all of the opponent's ships by hitting each square they occupy.");
        System.out.println("7. The first player to sink all of the opponent's ships wins the game.");
        System.out.println("8. During your turn, enter the coordinates for your shot (e.g., B7).");
        System.out.println("9. The game board uses '-' to represent water, 'S' for ships, 'H' for hits, and 'M' for misses.");
        System.out.println("10. Enjoy the game and may the best strategist win!");
        System.out.println("-------------------------------");
    }

    private void clearConsole() {
        if (isCPUPlaying){
        Console.clear();
        System.out.println("switching players...");
        //Console.pause(1000);
        Console.clear();}
        else {
            Console.clear();
            System.out.println("switching players...");
            Console.pause(3000);
            Console.clear();
        }
    }
}