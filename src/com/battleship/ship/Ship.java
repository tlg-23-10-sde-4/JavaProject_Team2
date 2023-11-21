package com.battleship.ship;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final ShipType type;
    private int hits;

    public Ship(ShipType type) {
        this.type = type;
        this.hits = 0;
    }

    // Creates the ships based off of user start grid
    public static List<String> generateShipPlacement(ShipType shipType, String location, boolean isHorizontal) {
        List<String> shipCoordinates = new ArrayList<>();
        int size = shipType.getSize();
        char firstChar = location.charAt(0);
        char secondChar = location.charAt(1);
        String firstLetter = String.valueOf(firstChar);
        String secondLetter = String.valueOf(secondChar);
        if (isHorizontal){
            for (int i = 0; i < size; i++){
                String result = firstLetter;
                String value = String.valueOf(secondChar);
                secondChar += 1;
                shipCoordinates.add(result+value);
            }
        }

        else {
            for (int i = 0; i < size; i++){
                String value = String.valueOf(firstChar);
                firstChar++;
                shipCoordinates.add(value+secondLetter);
            }
        }
        return shipCoordinates;
    }
}