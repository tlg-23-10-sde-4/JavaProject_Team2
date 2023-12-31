package com.battleship.player;

import com.battleship.boards.FiringBoard;
import com.battleship.boards.ShipBoard;
import com.battleship.ship.Ship;
import com.battleship.ship.ShipType;

import java.util.List;
import java.util.Random;

public class CPUPlayer extends Player {
    private static Random random;
    private static String previousHit;
    private static final String PATTERN = "[a-jA-J]{1}[0-9]{1}";

    public CPUPlayer() {
        random = new Random();
    }

    // CPU places ships
    @Override
    public void placeShips(ShipBoard shipBoard, FiringBoard firingBoard) {
        List<String> thisGeneratedShip;
        for (ShipType ship : ShipType.values()) {
            System.out.println("CPU is placing " + ship.getName());
            thisGeneratedShip = generateShip(ship, shipBoard);
            System.out.println(thisGeneratedShip);
            if (isValidBuild(thisGeneratedShip)) {
                shipBoard.placeShip(thisGeneratedShip);
                System.out.println("CPU placed " + ship.getName());
            }
        }
    }

    // CPU gets valid coordinates
    private String getCoordinates() {
        String coordinates;
        do {
            char letter = (char) (random.nextInt(9) + ('a'));
            char number = (char) (random.nextInt(10)-1);
            String s1 = String.valueOf(letter);
            String s2 = String.valueOf(number+1);
            coordinates = s1 + s2;
        } while (!coordinates.matches(PATTERN));
        return coordinates;
    }

    // CPU creates valid ships
    private List<String> generateShip(ShipType ship, ShipBoard shipBoard) {
        String shipPlacement;
        boolean isHorizontal;
        List<String> shipGenerated;

        do {
            shipPlacement = getCoordinates();
            isHorizontal = isShipHorizontal();
            shipGenerated = Ship.generateShipPlacement(ship, shipPlacement, isHorizontal);
        } while (!shipBoard.isValidPlacement(shipGenerated));
        do {
            shipPlacement = getCoordinates();
            isHorizontal = isShipHorizontal();
            shipGenerated = Ship.generateShipPlacement(ship, shipPlacement, isHorizontal);
        } while (!isValidBuild(shipGenerated));
        return shipGenerated;
    }

    private boolean isShipHorizontal() {
        return random.nextBoolean();
    }

    @Override
    public String takeTurn(FiringBoard firingBoard, ShipBoard shipBoard) {
        // rule-based shooting strategy
        String guess;

        if (firingBoard.getCpuHit() != null) {
            previousHit = firingBoard.getCpuHit();
            do {
                guess = generateNearbyTarget(previousHit, firingBoard);
            }while (!guess.matches(PATTERN));
        }

        else {
            if (firingBoard.getFireRecord() != null) {
                do {
                    guess = getCoordinates();
                } while (firingBoard.getFireRecord().contains(guess));
            }
            else {
                guess = getCoordinates();
            }
        }
        return guess;
    }
    // If CPU hits a ship, it will pick a random grid right next to it
    private String generateNearbyTarget(String previousHit, FiringBoard firingBoard) {
        String guess = null;
        char row = previousHit.charAt(0);
        char col = previousHit.charAt(1);

        // simple strategy, shoot above, below, left, or right of previous hit
        do {
            int direction = random.nextInt(4);
            switch (direction) {
                case 0: // above
                    guess = String.valueOf(row) + (col += 1);
                    break;
                case 1: //below
                    guess = String.valueOf(row) + (col -= 1);
                    break;
                case 2: // left
                    guess = String.valueOf(row -= 1) + col;
                    break;
                case 3: //right
                    guess = String.valueOf(row += 1) + col;
                    break;
                default:
                    return previousHit;
            }
        } while (firingBoard.getFireRecord().contains(guess));
            return guess;
        }
}