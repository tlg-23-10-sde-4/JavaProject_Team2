package com.battleship.boards;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShipBoardTest {

    @Test
    public void allShipsSunk_shouldAssertTrue_whenNull(){
        ShipBoard shipBoard1 = new ShipBoard();
        Assert.assertTrue(shipBoard1.allShipsSunk());
    }

    @Test
    public void allShipsSunk_shouldAssertFalse_whenAShipIsPresent() {
        ShipBoard shipBoard = new ShipBoard();
        List<String> ship = new ArrayList<>();
        ship.add("12");
        shipBoard.placeShip(ship);
        Assert.assertFalse(shipBoard.allShipsSunk());
    }

    @Test
    public void isValidPlacement_shouldReturnFalse_whenShipsOverlap(){
        ShipBoard shipBoard = new ShipBoard();
        List<String> ship = new ArrayList<>();
        List<String> ship2 = new ArrayList<>();
        ship.add("a1");
        ship.add("b1");
        shipBoard.placeShip(ship);
        ship.add("b2");
        ship2.add("b2");
        Assert.assertFalse(shipBoard.isValidPlacement(ship2));
    }

    @Test
    public void isValidPlacement_shouldReturnTrue_whenShipsDoNotOverlap(){
        ShipBoard shipBoard = new ShipBoard();
        List<String> ship = new ArrayList<>();
        List<String> ship2 = new ArrayList<>();
        ship.add("a1");
        ship.add("b1");
        shipBoard.placeShip(ship);
        ship2.add("b3");
        Assert.assertTrue(shipBoard.isValidPlacement(ship2));
    }
}