package com.battleship.player;

import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard; //ShipBoard needs to be public
import com.battleship.ship.Ship;
import com.battleship.ship.ShipType; //Ship and shiptype need to be in a package

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Player {

    private String fleetName;
    private final String pattern = "[a-jA-J]{1}[0-9]{1}";

    public Player() {

    }

    public Player(String name) {
        setFleetName(name);
    }

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public void placeShips(Scanner scanner, ShipBoard shipBoard){

        for (ShipType ship : ShipType.values()){
            System.out.println("Placing ship: " + ship.getName() + "; size: " + ship.getSize());
            String shipPlacement;
            boolean isHorizontal;

            System.out.println("Enter the position you want " + ship.getName() + " (e.g., C3): ");
            shipPlacement = scanner.next();
            System.out.println("Ship horizontal? (true/false)");
            isHorizontal = scanner.nextBoolean();
            ArrayList<String> shipGenerated = Ship.generateShipPlacement(ship, shipPlacement, isHorizontal);

            while (!shipPlacement.matches(pattern) || !ShipBoard.isValidPlacement(shipGenerated, isHorizontal, ship)) {
                System.out.println("That was either an invalid sequence or it won't fit in that " +
                        "location, valid sequence = A9. first being A-J and second being 0-9");
                shipPlacement = scanner.next();
                shipPlacement = shipPlacement.trim();
                shipGenerated = Ship.generateShipPlacement(ship, shipPlacement, isHorizontal);
            }


            ShipBoard.placeShip(ship, shipGenerated);
        }
    }

    public String takeTurn(Scanner scanner){

        System.out.println(getFleetName()+ " enter your guess (e.g., B7): ");
        scanner = new Scanner(System.in);
        String guess = scanner.next().toUpperCase();

        while (!guess.matches(pattern)){
            System.out.println("That is an invalid sequence, valid sequence = A9. first being A-J and second being 0-9");
            guess = scanner.next();
        }
        return guess;
    }
}