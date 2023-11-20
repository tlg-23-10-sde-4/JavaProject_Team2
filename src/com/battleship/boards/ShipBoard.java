package com.battleship.boards;

import java.util.ArrayList;

public class ShipBoard {

    //FIELDS
    private ArrayList<ArrayList<String>> shipBoard;
    private ArrayList<String> shipLocation;
    //CONSTRUCTOR
    public void placeShip(ArrayList<String> location) {
            if (shipBoard == null) {
                shipBoard = new ArrayList<>();
            }
            shipBoard.add(location);
        }

    //METHODS
    public boolean sink() {
        boolean result = false;
        System.out.println(shipBoard.size());
        for (ArrayList<String> boat : shipBoard) {
            if (boat.isEmpty()) {
                shipBoard.remove(boat);
                System.out.println("That ship is now sunk");
                result = true;
                break;
            }

        }
        System.out.println(shipBoard.size());
        System.out.println(shipBoard);
        return result;
    }

    public boolean isValidPlacement(ArrayList<String> location) {
        boolean result = false;
        if (shipBoard== null){
            shipBoard = new ArrayList<>();
            result = true;
        }
        for (ArrayList<String> shipList : shipBoard){
            for (String ship : shipList){
                if (!location.contains(ship)) {
                    result = true;
                }

                else {
                    System.out.println("One of the coordinates is intersecting with another ship, please try again.");
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public boolean allShipsSunk() {
        boolean result = false;
        if (shipBoard == null || shipBoard.size() == 0) {
            result = true;
        }
        return result;
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