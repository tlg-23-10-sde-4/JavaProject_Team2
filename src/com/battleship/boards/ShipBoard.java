package com.battleship.boards;

import com.battleship.player.Player;
import com.battleship.ship.Ship;
import com.battleship.ship.ShipType;

import java.util.ArrayList;

public class ShipBoard {

    //FIELDS
    public static ArrayList<ArrayList<String>> shipBoard;
    //CONSTRUCTOR
    public ShipBoard(ArrayList<String> ship) {
        if (isValidPlacement(ship)) {
            shipBoard.add(ship);
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

    // I think a switch case will work best for this along with a ternary in each case
    //TODO: for/each through the ship board to check if there are duplicates
    public static boolean isValidPlacement(ArrayList<String> location) {
        boolean result = false;
        for (String grid : location) {
            if (shipBoard.isEmpty()) {
                result = true;
            }
            else {
                for (ArrayList<String> boat : shipBoard) {
                    if (boat.contains(grid)) {
                        System.out.println("That ships grid causes a collision with another one of your ships! Please choose a new grid.");
                        result = false;
                    }
                    result = true;
                }
            }
        }
        return result;
    }

    // TODO: pass the given location array from player into the ship board
    public static void placeShip(ArrayList<String> location) {
        if (isValidPlacement(location)) {
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