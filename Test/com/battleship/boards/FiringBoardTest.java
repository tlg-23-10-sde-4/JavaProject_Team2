package com.battleship.boards;

import com.battleship.player.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FiringBoardTest {
    public String playerGuess;
    ShipBoard shipBoard = new ShipBoard();
    FiringBoard firingBoard = new FiringBoard(shipBoard);
    Player player = new Player();



/*    @Test
    public void fireRecord_shouldAddString_whenStringIsUnique() {
        playerGuess = "B7";
    }*/

    @Test
    public void fire_shouldWork_whenFireHitsShip() {
        List<String> aList = new ArrayList<>();
        aList.add("A1");
        shipBoard.placeShip(aList);
        shipBoard.printBoard();
        playerGuess = "A1";
        firingBoard.fire(playerGuess);
    }

    @Test
    public void impact_shouldReturnTrue_whenFiringBoardHits() {
        List<String> aList = new ArrayList<>();
        aList.add("A1");
        shipBoard.placeShip(aList);
        shipBoard.printBoard();
        playerGuess = "A1";
        boolean result = firingBoard.impact(playerGuess);
        Assert.assertTrue(result);
    }

    @Test
    public void impact_shouldReturnFalse_whenFiringBoardMisses() {
        List<String> aList = new ArrayList<>();
        aList.add("A1");
        aList.add("B2");
        aList.add("A2");
        shipBoard.placeShip(aList);
        shipBoard.printBoard();
        playerGuess = "A5";
        boolean result = firingBoard.impact(playerGuess);
        Assert.assertFalse(result);
    }

    @Test
    public void hit_shouldRemoveShip_whenValidShotHitsShip(){
        List<String> aList = new ArrayList<>();
        List<String> bList = new ArrayList<>();
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
        firingBoard.fire(playerGuess);
        shipBoard.printBoard();
        playerGuess = "D3";
        firingBoard.fire(playerGuess);
        shipBoard.printBoard();
        playerGuess = "A8";
        firingBoard.fire(playerGuess);
        shipBoard.printBoard();
    }


    //TODO add more tests
}
