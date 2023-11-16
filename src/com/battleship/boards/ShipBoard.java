package com.battleship.boards;

import com.battleship.player.Player;
import com.battleship.ship.Ship;
import com.battleship.ship.ShipType;

import java.util.ArrayList;

public class ShipBoard {

    //FIELDS
    public static ArrayList<ArrayList<String>> shipBoard;
    public static ArrayList<String> loadingDock;
    //CONSTRUCTOR
    public static void placeShip(ArrayList<String> location) {
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

    // I think a switch case will work best for this along with a ternary in each case
    public static boolean isValidPlacement(ArrayList<String> location) {
        boolean result = false;
        if (shipBoard == null) {
            result = true;
        }
        else {
            for (String grid : location) {
                for (ArrayList<String> boat : shipBoard) {
                    if (boat.contains(grid)) {
                        System.out.println("That ships grid causes a collision with another one of your ships!" +
                                " Please choose a new grid.");
                        result = false;
                    }
                    result = true;
                }
            }
        }
        return result;
    }

    public static boolean allShipsSunk() {
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