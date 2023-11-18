package com.battleship.boards;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ShipBoardTest {

    @Test
    public void allShipsSunk_shouldAssertTrue_whenNull(){
        ShipBoard shipBoard1 = new ShipBoard();
        Assert.assertTrue(shipBoard1.allShipsSunk());
    }

    @Test
    public void allShipsSunk_shouldAssertFalse_whenAShipIsPresent() {
        ShipBoard shipBoard = new ShipBoard();
        ArrayList<String> ship = new ArrayList<>();
        ship.add("12");
        shipBoard.placeShip(ship);
        Assert.assertFalse(shipBoard.allShipsSunk());
    }
}