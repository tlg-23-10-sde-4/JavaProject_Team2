package com.battleship.boards;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;

class ShipBoard {
    //FIELDS
    HashMap<Array, Array> shipBoard;

    //ACCESSORS
    public HashMap<Array, Array> getShipBoard() {
        return shipBoard;
    }

    public void setShipBoard(HashMap<Array, Array> shipBoard) {
        this.shipBoard = shipBoard;
    }
}