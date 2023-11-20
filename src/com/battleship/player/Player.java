package com.battleship.player;

import com.battleship.boards.ShipBoard;
import com.battleship.ship.Ship;
import com.battleship.ship.ShipType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    private static final String PATTERN = "[a-jA-J]{1}[0-9]{1}";
    private static final Scanner scanner = new Scanner(System.in);
    public static String guess;

    public Player() {
    }

    // TODO Game ends after turn/ or try catch if triggered/ need to fix
    public void placeShips(ShipBoard shipBoard) {
        ArrayList<String> thisGeneratedShip;

        try {
        for (ShipType ship : ShipType.values()) {
            System.out.println("Placing ship: " + ship.getName() + "; size: " + ship.getSize());
            thisGeneratedShip = generateShip(ship, shipBoard);
            if (isValidBuild(thisGeneratedShip)) {
                shipBoard.placeShip(thisGeneratedShip);
            }
            }
        }catch (StringIndexOutOfBoundsException e){
            System.out.println("valid range is a-j and 0-9: e.g., a7");
        }
    }

    private boolean isShipHorizontal(){
        boolean result = false;
        String word = "";
        System.out.println("Ship horizontal? (true/false)");
        try {
            word = scanner.next().trim();
            if (word.equals("t") || word.equals("T")){
                word = "true";
            }
            if (word.equals("f") || word.equals("F")){
                word = "false";
            }
            result = Boolean.parseBoolean(word);
        }catch (InputMismatchException e){
            System.out.println("true or false");
        }
        return result;
    }

    public boolean isValidBuild(ArrayList<String> ship){
        boolean result = false;
        for (String s : ship){
            result = s.matches(PATTERN);
        }
        return result;
    }

    private ArrayList<String> generateShip(ShipType ship, ShipBoard shipBoard) {
        String shipPlacement;
        boolean isHorizontal;
        ArrayList<String> shipGenerated;

        do {
            System.out.println("Enter the position you want " + ship.getName() + " (e.g., C3): ");
            shipPlacement = getCoordinates();
            //System.out.println("Ship horizontal? (true/false)");
            isHorizontal = isShipHorizontal();
            shipGenerated = Ship.generateShipPlacement(ship, shipPlacement, isHorizontal);
        } while (!shipBoard.isValidPlacement(shipGenerated));

        return shipGenerated;
    }

    private String getCoordinates(){
        return scanner.next().trim().toUpperCase();
    }

    public String takeTurn() {
        System.out.println(" enter your firing coordinate (e.g., B7): ");
        guess = getCoordinates();

        while (!guess.matches(PATTERN)) {
            System.out.println("Invalid coordinate, valid coordinate = A9. first being A-J and second being 0-9");
            guess = getCoordinates();
        }
        return guess;
    }

    public static String getGuess() {
        return guess;
    }
}