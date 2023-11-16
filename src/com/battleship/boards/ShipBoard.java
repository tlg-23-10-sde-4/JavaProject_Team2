package com.battleship.boards;

import com.battleship.ship.Ship;
import com.battleship.ship.ShipType;

import java.util.ArrayList;

public class ShipBoard {

    //FIELDS
    public static ArrayList<ArrayList<String>> shipBoard;

    public ShipBoard(int boardSize) { // gage - create a constructor
    }

    public static boolean isValidPlacement(String location, boolean isHorizontal, ShipType shipType){
        boolean result = false;
        char first = location.charAt(0);
        char second = location.charAt(1);
        int shipLength = shipType.getSize();
        if (isHorizontal){
            //TODO implement this thought
            // first <= f for aircraft carrier
            // first <= g for battleship
            // first <= h for destroyer and sub
            // first <= i for small ship
        }
        else {
            //TODO implement this
            // second <= 6 for aircraft carrier
            // second <= 7 for battleship
            // second <= 8 for destroyer and sub
            // second <= 9 for small ship
        }
        return result;
    }

    //ACCESSORS
    public static ArrayList<ArrayList<String>> getShipBoard() {
        return shipBoard;
    }

    public static void placeShip(ShipType ship) {
        // TODO implement this
    }

    public void setShipBoard(ArrayList<ArrayList<String>> shipBoard) {
        ShipBoard.shipBoard = shipBoard;
    }

}