package com.battleship.boards;

import java.util.ArrayList;

public class ShipBoard {

    //FIELDS
    private ArrayList<ArrayList<String>> shipBoard;
    private ArrayList<String> shipLocation;
    //CONSTRUCTOR
    public void placeShip(ArrayList<String> location) {
//        if (isValidPlacement(location)) {
            if (shipBoard == null || shipBoard.isEmpty()) {
                shipBoard = new ArrayList<>();
            }
            shipBoard.add(location);
        }


    //METHODS
    public boolean sink(ShipBoard shipBoard) {
        boolean result = false;
        for (ArrayList<String> boat : shipBoard.getShipBoard()) {
            if (boat.size() == 0) {
                result = true;
                break;
            }
        }
        return result;
    }

    // TODO still need to test if this is working properly now
    public boolean isValidPlacement(ArrayList<String> location) {
        int count = 0;
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
                    break;
                }
                else {
                    shipLocation.add(grid);
                    System.out.println("shipLocation= "+shipLocation);
                    result = true;
                }
            }
            for (ArrayList<String> ship : shipBoard) {
                for (String loc : location){
                    if (ship.contains(loc)) {
                        shipLocation.clear();
                        result = false;
                        break;
                    }
                    else {
                        result = true;
                    }
                }
            }
            if (result) {
                placeShip(shipLocation);
                shipLocation.clear();
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