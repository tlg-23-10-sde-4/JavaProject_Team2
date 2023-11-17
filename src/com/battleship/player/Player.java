package com.battleship.player;

import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard;
import com.battleship.ship.Ship;
import com.battleship.ship.ShipType;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private static final String PATTERN = "[a-jA-J]{1}[0-9]{1}";
    private static final Scanner scanner = new Scanner(System.in);
    public static String guess;

    public Player() {
        ShipBoard shipBoard = new ShipBoard();
        FiringBoard firingBoard = new FiringBoard();
    }

    public void placeShips(ShipBoard shipBoard) {

        for (ShipType ship : ShipType.values()) {
            System.out.println("Placing ship: " + ship.getName() + "; size: " + ship.getSize());
            String shipPlacement;
            boolean isHorizontal;

            System.out.println("Enter the position you want " + ship.getName() + " (e.g., C3): ");
            shipPlacement = scanner.next();
            System.out.println("Ship horizontal? (true/false)");
            isHorizontal = scanner.nextBoolean();
            ArrayList<String> shipGenerated = Ship.generateShipPlacement(ship, shipPlacement, isHorizontal);

            //TODO make invalid ship placements still have a chance to get placed and not just skipped
            // probably split this into more than one method i.e., isHorizontal(), placeShip()
            while (!shipPlacement.matches(PATTERN) || !ShipBoard.isValidPlacement(shipGenerated)) {
                System.out.println("That was either an invalid coordinate or it won't fit in that " +
                        "location, valid coordinate = A9. first being A-J and second being 0-9");
                System.out.println("Place ship " + ship.getName());
                shipPlacement = scanner.next();
                shipPlacement = shipPlacement.trim();
                shipGenerated = Ship.generateShipPlacement(ship, shipPlacement, isHorizontal);
            }
            ShipBoard.placeShip(shipGenerated);
        }
    }

    public static String takeTurn(FiringBoard firingBoard) {

        System.out.println(" enter your firing coordinate (e.g., B7): ");
        guess = scanner.next().toUpperCase();

        while (!guess.matches(PATTERN)) {
            System.out.println("Invalid coordinate, valid coordinate = A9. first being A-J and second being 0-9");
            guess = scanner.next();
        }
        return guess;
    }

    public ShipBoard getShipBoard() {
        return shipBoard;
    }

    public boolean hasLost() {
        return shipBoard.allShipsSunk();
    }
}