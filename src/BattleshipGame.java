public class BattleshipGame {
    private static final int BOARD_SIZE = 10; // size of the game board
    private static final int SHIP_COUNT = 5; // total number of ships placed on the board
    // TODO: create an array representing the game board
    private final boolean[] shipsSunk = new boolean[SHIP_COUNT]; // array to track the status of each ship (sunk or not)
    private final int shipsRemaining = SHIP_COUNT; // count not sunk ships

    public BattleshipGame() {
        // TODO: initialize the board
        // TODO: place ships (each player sets their respective ships)
    }

    // TODO: game board method

    // TODO: place ships on the board method

    // TODO: print board to console method

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame();
        game.startGame(); // calling method in Player() class
    }
}