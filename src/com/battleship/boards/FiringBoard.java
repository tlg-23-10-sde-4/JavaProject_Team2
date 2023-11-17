package com.battleship.boards;

import com.battleship.player.Player;

import java.util.ArrayList;

public class FiringBoard {

//FIELDS
    private static ArrayList<String> fireRecord;

    private static ArrayList<String> firingBoardHits;

    private ArrayList<String> firingBoardMisses;

    private String aiming;

    //METHODS
    public boolean fire() {
        boolean validShot = false;
        if (fireRecord == null) {
            fireRecord = new ArrayList<>();
            fireRecord.add(gridAim());
            validShot = true;
        }
        for (String shot : fireRecord) {
            if (gridAim().equals(shot)) {
                System.out.println("That grid has already been hit!");
                validShot = false;
            }
            else {
                fireRecord.add(gridAim());
                impact();
                validShot = true;
            }
        }
        return validShot;
    }
    public boolean impact() {
        boolean result = false;
        for (ArrayList<String> boat : ShipBoard.getShipBoard()){
            if (boat.contains(gridAim())) {
                firingBoardHits.add("X-" + gridAim());
                System.out.println("That round hit a ship!" + gridAim());
                hit();
                result = true;
            }
            else {
                fireRecord.add("O-" + gridAim());
                System.out.println("That round hit water." + gridAim());
                result = false;
            }
        }
        return result;
    }

    private void hit() {
        for (String hit : getFiringBoardHits()) {
            for (ArrayList<String> boat : ShipBoard.getShipBoard())
                boat.remove(hit);
        }
    }

    public void printBoard() {
        System.out.println(fireRecord);
    }

    //ACCESSOR METHODS
    public ArrayList<String> getFireRecord() {
        return fireRecord;
    }

    public static ArrayList<String> getFiringBoardHits() {
        return firingBoardHits;
    }

    public static void setFiringBoardHits(ArrayList<String> firingBoardHits) {
        FiringBoard.firingBoardHits = firingBoardHits;
    }

    public ArrayList<String> getFiringBoardMisses() {
        return firingBoardMisses;
    }

    public void setFiringBoardMisses(ArrayList<String> firingBoardMisses) {
        this.firingBoardMisses = firingBoardMisses;
    }

    public String gridAim() {
        return Player.guess;
    }
    //HELPERS
}