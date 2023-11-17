package com.battleship.boards;

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
            fireRecord.add(takeTurn());
            validShot = true;
        }
        for (String shot : fireRecord) {
            if (takeTurn().equals(shot)) {
                System.out.println("That grid has already been hit!");
                validShot = false;
            }
            else {
                fireRecord.add(takeTurn());
                impact();
                validShot = true;
            }
        }
        return validShot;
    }
    private void impact() {
        for (ArrayList<String> boat : ShipBoard.getShipBoard()){
            if (boat.contains(takeTurn())) {
                firingBoardHits.add("X-" + takeTurn());
                System.out.println("That round hit a ship!" + takeTurn());
                hit();
            }
            else {
                fireRecord.add("O-" + takeTurn());
                System.out.println("That round hit water." + takeTurn());
            }
        }
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

    public void setFireRecord(ArrayList<String> fireRecord) {
        FiringBoard.fireRecord = fireRecord;
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

    public String takeTurn() {
        return aiming;
    }

    //HELPERS
}