package com.battleship.boards;

import java.util.HashMap;
public class FiringBoard {

//FIELDS
    private String[] fireMap;

    private String[] firingBoardHits;

    private String[] firingBoardMisses;

    private String aiming;

    //CONSTRUCTOR

    public FiringBoard(int boardSize) {
    }


    //METHODS
    public void fire() {

    }

    //ACCESSOR METHODS
    public String[] getFireMap() {
        return fireMap;
    }

    public void setFireMap(String[] fireMap) {
        this.fireMap = fireMap;
    }

    public String[] getFiringBoardHits() {
        return firingBoardHits;
    }

    public void setFiringBoardHits(String[] firingBoardHits) {
        this.firingBoardHits = firingBoardHits;
    }

    public String[] getFiringBoardMisses() {
        return firingBoardMisses;
    }

    public void setFiringBoardMisses(String[] firingBoardMisses) {
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