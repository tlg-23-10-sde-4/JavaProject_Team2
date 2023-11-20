package com.battleship.boards;

import java.util.ArrayList;
import java.util.List;

public class ShipBoard {

    //FIELDS
    private List<List<String>> shipBoard;
    private List<String> shipLocation;
    //CONSTRUCTOR
    public void placeShip(List<String> location) {
            if (shipBoard == null) {
                shipBoard = new ArrayList<>();
            }
            shipBoard.add(location);
        }

    //METHODS
    public boolean sink() {
        boolean result = false;
        System.out.println(shipBoard.size());
        for (List<String> boat : shipBoard) {
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

    public boolean isValidPlacement(List<String> location) {
        boolean result = false;
        if (shipBoard== null){
            shipBoard = new ArrayList<>();
            result = true;
        }
        for (List<String> shipList : shipBoard){
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
    public List<List<String>> getShipBoard() {
        return shipBoard;
    }


    public void printBoard() {
        for (List<String> boats : shipBoard) {
            System.out.println(boats);
        }
    }
}