package com.battleship.boards;

import com.battleship.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class FiringBoardTest {
    public String playerGuess;
    FiringBoard firingBoard = new FiringBoard();
    Player player = new Player();
    ShipBoard shipBoard = new ShipBoard();


/*    @Test
    public void fireRecord_shouldAddString_whenStringIsUnique() {
        playerGuess = "B7";
    }*/

    @Test
    public void fire_shouldWork_whenFireHitsShip() {
        ArrayList<String> aList = new ArrayList<>();
        aList.add("A1");
        shipBoard.placeShip(aList);
        shipBoard.printBoard();
        playerGuess = "A1";
        firingBoard.fire(playerGuess, shipBoard);
    }

    @Test
    public void impact_shouldReturnTrue_whenFiringBoardHits() {
        ArrayList<String> aList = new ArrayList<>();
        aList.add("A1");
        shipBoard.placeShip(aList);
        shipBoard.printBoard();
        playerGuess = "A1";
        boolean result = firingBoard.impact(playerGuess, shipBoard);
        Assert.assertTrue(result);
    }

    @Test
    public void impact_shouldReturnFalse_whenFiringBoardMisses() {
        ArrayList<String> aList = new ArrayList<>();
        aList.add("A1");
        shipBoard.placeShip(aList);
        shipBoard.printBoard();
        playerGuess = "A2";
        boolean result = firingBoard.impact(playerGuess, shipBoard);
        Assert.assertFalse(result);
    }

    @Test
    public void hit_shouldRemoveShip_whenValidShotHitsShip(){
        ArrayList<String> aList = new ArrayList<>();
        aList.add("A1");
        aList.add("B2");
        shipBoard.placeShip(aList);
        shipBoard.printBoard();
        playerGuess = "A1";
        firingBoard.fire(playerGuess, shipBoard);
        shipBoard.printBoard();
        System.out.println("Should only have B2 above this");
    }

    //TODO add more tests
}
