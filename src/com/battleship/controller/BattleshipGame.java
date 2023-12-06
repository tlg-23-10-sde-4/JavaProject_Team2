package com.battleship.controller;

import com.apps.util.Console;
import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard;
import com.battleship.player.CPUPlayer;
import com.battleship.player.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BattleshipGame {
    private final Player player1;
    private final Player player2;
    private final ShipBoard player1Shipboard = new ShipBoard();
    private final ShipBoard player2Shipboard = new ShipBoard();
    private final FiringBoard player1FiringBoard = new FiringBoard(player2Shipboard);
    private final FiringBoard player2FiringBoard = new FiringBoard(player1Shipboard);
    private boolean isCPUPlaying = false;
    private String bannerDirectory = "src/com/battleship/banners/";

    // Creates the board and it's players
    public BattleshipGame() throws IOException {
        showBanner("banner_for_battleship.txt");
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
    public void startGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to see the tutorial? (yes/no)");
        String response = scanner.nextLine().trim().toLowerCase();
        if (response.equals("yes") || response.equals("y")) {
            showTutorial();
            System.out.println("Type any letter and press enter to continue");
            response = scanner.next();
            Console.clear();
        }
        Console.clear();
        placeShipsForPlayers();
        playRounds();
    }

    // displays banners in game
    private void showBanner(String bannerFileName) throws IOException {
        Path filepath = Path.of(bannerDirectory + bannerFileName);
        if (Files.exists(Path.of(bannerDirectory + bannerFileName))) {
            try {
                String bannerContent = Files.readString(filepath);
                System.out.println(bannerContent);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // ship placement management
    private void placeShipsForPlayers() throws IOException {
        System.out.println("Player 1, place your ships:");
        player1.placeShips(player1Shipboard, player2FiringBoard);
        clearConsole();

        System.out.println("Player 2, place your ships:");
        player2.placeShips(player2Shipboard, player1FiringBoard);
        clearConsole();
    }

    // game round management
    public void playRounds() throws IOException {
        while (!player1Shipboard.allShipsSunk() && !player2Shipboard.allShipsSunk()) {
            takeTurns(player1, player2);
        }
    }

    // player turn management
    private void takeTurns(Player player1, Player player2) throws IOException {
        while (!player1Shipboard.allShipsSunk() && !player2Shipboard.allShipsSunk()) {
            System.out.println("Player 1's shipBoard.");
            player1Shipboard.printShipBoard(player2FiringBoard);

            System.out.println("Player 1's firing board: ");
            player1FiringBoard.printFiringBoard();

            System.out.println("Player 1's turn to fire: ");
            player1FiringBoard.fire(player1.takeTurn(player1FiringBoard, player2Shipboard));

            if (!player1FiringBoard.impact(Player.getGuess())) {
                System.out.println("that round was a miss!");
                Console.pause(1500);
            }
            if (player1FiringBoard.impact(Player.getGuess())) {
                System.out.println("that round hit a ship!");
                Console.pause(1500);
            }
            if (player2Shipboard.sink()) {
                System.out.println("Player 2's ship has been sunk!");
                Console.pause(2000);
            }
            if (player2Shipboard.allShipsSunk()) {
                showBanner("end_game_banner.txt");
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
                Console.pause(2000);
            }
            if (player1Shipboard.allShipsSunk()) {
                showBanner("end_game_banner.txt");
                System.out.println("Player 2 has won!");
                break;
            }
            clearConsole();
        }
    }

    public void showTutorial() throws IOException {
        showBanner("tutorial_banner.txt");
    }

    private void clearConsole() throws IOException {
        if (isCPUPlaying){
        Console.clear();
        showBanner("switching_player_banner.txt");
        //Console.pause(1000);
        Console.clear();}
        else {
            Console.clear();
            showBanner("switching_player_banner.txt");
            Console.pause(3000);
            Console.clear();
        }
    }
}