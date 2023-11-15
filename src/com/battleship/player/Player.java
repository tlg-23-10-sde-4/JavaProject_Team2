package com.battleship.player;

import com.battleship.boards.ShipBoard; //ShipBoard needs to be public
import com.battleship.ship.ShipType; //Ship and shiptype need to be in a package

import java.util.Scanner;
import java.util.regex.Pattern;

public class Player {

    private String fleetName;

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public void placeShips(Scanner scanner, ShipBoard shipBoard){
        for (ShipType ship : ShipType.values()){
            System.out.println("Placing ship: " + ship.getName() + "; size: " + ship.getSize());
            String row;
            int col;
            boolean isHorizontal;
            Pattern pattern;

            do {
                System.out.println("Enter the row (A-J): ");
                row = scanner.next().toUpperCase();
                System.out.println("Enter the col (1-10): ");
                col = scanner.nextInt() - 1;
                System.out.println("Ship horizontal? (true/false)");
                isHorizontal = scanner.nextBoolean();
            } while (!ShipBoard.isValidPlacement(row, col, isHorizontal));

            ShipBoard.placeShip(ship);
        }
    }

}