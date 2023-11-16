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
            }
        }
    }
    public void impact() {
        for (ArrayList<String> boat : ShipBoard.getShipBoard()){
            if (boat.contains(getAiming())) {
                firingBoardHits.add(getAiming());
                System.out.println("That round hit a ship!" + getAiming());
            }
            else {
                firingBoardMisses.add(getAiming());
                System.out.println("That round hit water." + getAiming());
            }
        }
    }

    //TODO: write a "sink()" in ship board, and delete an arraylist once the list contains null or length 0.
    public void hit() {
        for (String hit : getFiringBoardHits()) {
            for (ArrayList<String> boat : ShipBoard.getShipBoard())
                boat.remove(hit);
        }
    }

    //TODO implement a way to show the board
    public void printBoard() {
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