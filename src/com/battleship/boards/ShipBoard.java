package com.battleship.boards;

import com.battleship.player.Player;
import com.battleship.ship.Ship;
import com.battleship.ship.ShipType;

import java.util.ArrayList;

public class ShipBoard {

    //FIELDS
    public static ArrayList<ArrayList<String>> shipBoard;

    public ShipBoard(int boardSize) { // gage - create a constructor
    }

    //METHODS
    public void sink() {
        for (ArrayList<String> boat : shipBoard) {
            if (boat.size()== 0) {
                shipBoard.remove(boat);
            }
        }
    }

    // I think a switch case will work best for this along with a ternary in each case
    public static boolean isValidPlacement(ArrayList<String> location, boolean isHorizontal, ShipType shipType){
        boolean result = false;
        String first = location.get(0);
        String second = location.get(1);
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

    // This may need some rework
    public static void placeShip(ShipType ship, ArrayList<String> location) {
        // TODO implement this
        boolean isHorizontal = false;
        ShipType shipType = null;
        // verifies ship is valid before
        if (isValidPlacement(location, isHorizontal, shipType)){
            shipBoard.add(location);
        }
    }

    //TODO implement
    public boolean allShipsSunk() {
        return shipBoard.size() == 0;
    }

    //ACCESSORS
    public static ArrayList<ArrayList<String>> getShipBoard() {
        return shipBoard;
    }

    public void setShipBoard(ArrayList<ArrayList<String>> shipBoard) {
        ShipBoard.shipBoard = shipBoard;
    }
}