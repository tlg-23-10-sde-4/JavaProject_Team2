package com.battleship.boards;

import com.battleship.player.Player;
import com.battleship.ship.Ship;
import com.battleship.ship.ShipType;

import java.util.ArrayList;

public class ShipBoard {

    //FIELDS
    private static ArrayList<ArrayList<String>> shipBoard;
    private ArrayList<String> shipLocation;
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
    public boolean sink() {
        boolean result = false;
        for (ArrayList<String> boat : shipBoard) {
            if (boat.size()== 0) {
                shipBoard.remove(boat);
                result = true;
            }
        }
        return result;
    }

    public boolean isValidPlacement(ArrayList<String> location) {
        boolean result = false;
        if (shipLocation == null) {
            shipLocation = new ArrayList<>();
            result = true;
        }
        else {

            for (String grid : location) {
                if (shipLocation.contains(grid)) {
                    System.out.println("That ship grid causes a collision with a boat, \n Please choose a new grid.");
                    result = false;
                }
                else {
                    shipLocation.add(grid);
                    //shipBoard.add(location);
                    result = true;
                }

            }
        }
        return result;
    }

    public boolean allShipsSunk() {
        return (shipBoard == null || shipBoard.size() == 0);
    }

    //ACCESSORS
    public ArrayList<ArrayList<String>> getShipBoard() {
        return shipBoard;
    }


    public void printBoard() {
        for (ArrayList<String> boats : shipBoard) {
            System.out.println(boats);
        }
    }
}