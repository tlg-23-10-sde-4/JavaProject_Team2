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
    // TODO need the boats to be fully removed from shipboard
    public boolean sink(ShipBoard boatLocation) {
        boolean result = false;
        System.out.println(shipBoard.size());
        for (ArrayList<String> boat : shipBoard) {
            if (boat.isEmpty()) {
                shipBoard.remove(boat);
                System.out.println("That ship is now sunk");
                result = true;
                break;
            }
            System.out.println(shipBoard.size());
        }
        System.out.println(shipBoard);
        return result;
    }

//    //TODO implement this so that the shipboard can update and remove the empty arrays that aren't being removed
//    private ArrayList<ArrayList<String>> removeEmptyArrays(ShipBoard shipBoard){
//        ArrayList<ArrayList<String>> updatedShipBoard = new ArrayList<>();
//        for (ArrayList<String> ship : shipBoard.getShipBoard()){
//            if (!ship.isEmpty()){
//                updatedShipBoard.add(ship);
//            }
//        }
//        return updatedShipBoard;
//    }

    // TODO still need to test if this is working properly now
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
        /*else {
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
        }*/
        return result;
    }

    public boolean allShipsSunk() {
        return (shipBoard == null || shipBoard.isEmpty() || shipBoard.size() == 0);
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