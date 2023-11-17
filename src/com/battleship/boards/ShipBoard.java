package com.battleship.boards;

import com.battleship.player.Player;
import com.battleship.ship.Ship;
import com.battleship.ship.ShipType;

import java.util.ArrayList;

public class ShipBoard {

    //FIELDS
    private static ArrayList<ArrayList<String>> shipBoard;

    //CONSTRUCTOR
    public void placeShip(ArrayList<String> location) {
        if (isValidPlacement(location)) {
            if (shipBoard == null) {
                shipBoard = new ArrayList<>();
            }
            shipBoard.add(location);
        }
    }

    //METHODS
    public void sink() {
        for (ArrayList<String> boat : shipBoard) {
            if (boat.size()== 0) {
                shipBoard.remove(boat);
            }
        }
    }

    public boolean isValidPlacement(ArrayList<String> location) {
        boolean result = false;
        if (shipBoard == null) {
            result = true;
        }
        else {
            for (String grid : location) {
                for (ArrayList<String> boat : shipBoard) {
                    if (boat.contains(grid)) {
                        System.out.println("That ship grid causes a collision with " + boat +
                                " Please choose a new grid.");
                        result = false;
                    }
                    else {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    public boolean allShipsSunk() {
        return shipBoard.size() == 0;
    }

    //ACCESSORS
    public static ArrayList<ArrayList<String>> getShipBoard() {
        return shipBoard;
    }


    public void printBoard() {
        for (ArrayList<String> boats : shipBoard) {
            System.out.println(boats);
        }
    }
}