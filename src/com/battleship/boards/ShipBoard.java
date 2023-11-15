package com.battleship.boards;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShipBoard {

    //FIELDS
    public static ArrayList<ArrayList<String>> shipBoard;

    public ShipBoard(int boardSize) { // gage - create a constructor
    }

    //ACCESSORS
    public static ArrayList<ArrayList<String>> getShipBoard() {
        return shipBoard;
    }

    public void setShipBoard(ArrayList<ArrayList<String>> shipBoard) {
        ShipBoard.shipBoard = shipBoard;
    }

}