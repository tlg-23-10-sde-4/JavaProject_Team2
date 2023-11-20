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
        aList.add("B2");
        aList.add("A2");
        shipBoard.placeShip(aList);
        shipBoard.printBoard();
        playerGuess = "A5";
        boolean result = firingBoard.impact(playerGuess, shipBoard);
        Assert.assertFalse(result);
    }

    @Test
    public void hit_shouldRemoveShip_whenValidShotHitsShip(){
        ArrayList<String> aList = new ArrayList<>();
        ArrayList<String> bList = new ArrayList<>();
        aList.add("B3");
        aList.add("A2");
        aList.add("A1");
        aList.add("A4");
        aList.add("B2");
        bList.add("D3");
        bList.add("D2");
        bList.add("D1");
        bList.add("D4");
        bList.add("D7");
        shipBoard.placeShip(aList);
        shipBoard.placeShip(bList);
        playerGuess = "A1";
        firingBoard.fire(playerGuess, shipBoard);
        shipBoard.printBoard();
        playerGuess = "D3";
        firingBoard.fire(playerGuess, shipBoard);
        shipBoard.printBoard();
        playerGuess = "A8";
        firingBoard.fire(playerGuess, shipBoard);
        shipBoard.printBoard();
    }


    //TODO add more tests
}
