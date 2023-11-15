import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard;
import com.battleship.player.Player;

import java.util.Scanner;

public class BattleshipGame {
    private static final int BOARD_SIZE = 10; // size of the game board
    private static final int SHIP_COUNT = 5; // total number of ships placed on the board
    private ShipBoard playerBoard;
    private FiringBoard firingBoard;
    private Player player;
    private boolean gameOver = false;

    public BattleshipGame() {
        // initialize the shipBoard and firingBoard
        shipBoard = new ShipBoard(BOARD_SIZE);
        firingBoard = new FiringBoard(BOARD_SIZE);
        Player player = new Player();
        // TODO: place ships (each player sets their respective ships)
    }

    // game board method
    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        player.placeShips(scanner, playerBoard);
        while (!gameOver) {
            // TODO: players take turns firing at each other's ships
        }
    }

    // TODO: place ships on the board method

    // TODO: print board to console method

    public static void main(String[] args) {
        new BattleshipGame().startGame();
    }
}