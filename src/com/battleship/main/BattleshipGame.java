package com.battleship.main;
import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard;
import com.battleship.player.Player;

public class BattleshipGame {
    private final Player player1;
    private final Player player2;
    private final ShipBoard player1Shipboard = new ShipBoard();
    private final ShipBoard player2Shipboard = new ShipBoard();
    private final FiringBoard player1FiringBoard = new FiringBoard();
    private final FiringBoard player2FiringBoard = new FiringBoard();


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
        player1.placeShips(player1Shipboard);

        System.out.println("Player 2, place your ships:");
        player2.placeShips(player2Shipboard);
    }

    // game round management
    private void playRounds() {
        while (!player1Shipboard.allShipsSunk() && !player2Shipboard.allShipsSunk()) { // alternate turns until a 'player' loses
            System.out.println("Player 1's turn to fire:");
            takeTurns(player1, player2);

            if (player1Shipboard.allShipsSunk()){
                System.out.println("Player 2 has won");
            }
            if (player2Shipboard.allShipsSunk()){
                System.out.println("Player 1 has won");
            }
        }
    }

    // player turn management
    private void takeTurns(Player player1, Player player2) {
        System.out.println(player1.getClass().getName() + " Player's turn to fire: ");

        player1FiringBoard.printBoard();
        player1FiringBoard.fire(player1.takeTurn(), player2Shipboard);
        player2Shipboard.printBoard();

        player2FiringBoard.printBoard();
        player2FiringBoard.fire(player2.takeTurn(), player1Shipboard);
        player1Shipboard.printBoard();
    }

    // main method
    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.startGame();
    }
}