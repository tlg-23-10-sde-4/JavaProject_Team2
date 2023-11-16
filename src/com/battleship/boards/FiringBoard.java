package com.battleship.boards;

import java.util.ArrayList;
import com.battleship.boards.ShipBoard.*;
public class FiringBoard {

//FIELDS
    private ArrayList<String> fireRecord;

    private ArrayList<String> firingBoardHits;

    private ArrayList<String> firingBoardMisses;

    private String aiming;

    //CONSTRUCTOR

    public FiringBoard(int boardSize) {
    }

    //METHODS
    public void fire() {
        for (String shot : fireRecord) {
            if (getAiming().equals(shot)) {
                System.out.println("That grid has already been hit!");
            }
            else {
                fireRecord.add(getAiming());
                impact();
            }
        }
    }
    private void impact() {
        for (ArrayList<String> boat : ShipBoard.getShipBoard()){
            if (boat.contains(getAiming())) {
                firingBoardHits.add("X-" + getAiming());
                System.out.println("That round hit a ship!" + getAiming());
                hit();
            }
            else {
                firingBoardMisses.add("O-" + getAiming());
                System.out.println("That round hit water." + getAiming());
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
        this.fireRecord = fireRecord;
    }

    public ArrayList<String> getFiringBoardHits() {
        return firingBoardHits;
    }

    public void setFiringBoardHits(ArrayList<String> firingBoardHits) {
        this.firingBoardHits = firingBoardHits;
    }

    public ArrayList<String> getFiringBoardMisses() {
        return firingBoardMisses;
    }

    public void setFiringBoardMisses(ArrayList<String> firingBoardMisses) {
        this.firingBoardMisses = firingBoardMisses;
    }

    public String getAiming() {
        return aiming;
    }

    public void setAiming(String aiming) {
        this.aiming = aiming;
    }

    //HELPERS
}