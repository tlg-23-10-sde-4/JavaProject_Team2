package com.battleship.boards;

import com.battleship.player.Player;

import java.util.ArrayList;

public class FiringBoard {

//FIELDS
    private ArrayList<String> fireRecord;

    private ArrayList<String> firingBoardHits;

    private ArrayList<String> firingBoardMisses;

    private String aiming;

    //METHODS
    public void fire(String aim, ShipBoard shipBoard) {
        if (fireRecord == null) {
            firingBoardHits = new ArrayList<>();
            firingBoardMisses = new ArrayList<>();
            fireRecord = new ArrayList<>();
            fireRecord.add(aim);
            impact(aim, shipBoard);
        }
        else {
            for (String shot : fireRecord) {
                if (aim.equals(shot)) {
                    System.out.println("That grid has already been hit!");
                    break;
                } else {
                    fireRecord.add(aim);
                    impact(aim, shipBoard);
                    break;
                }
            }
        }
    }

    public boolean impact(String aim, ShipBoard shipBoard) {
        boolean result = false;
        for (ArrayList<String> boat : shipBoard.getShipBoard()){

            for (String b : boat) {
                if (b.equals(aim)) {
                    firingBoardHits.add("X-" + aim);
                    System.out.println("That round hit a ship! " + aim);
                    hit(aim, shipBoard);
                    result = true;
                    break;

                } /*else {
                    fireRecord.add("O" + aim);
                    System.out.println("That round hit water. " + aim);
                    result = false;

                }*/
            }
        }
        return result;
    }

    private void hit(String guess, ShipBoard shipBoard) {
        for (ArrayList<String> boat : shipBoard.getShipBoard()){
            boat.remove(guess);
        }
    }

    public void printBoard() {
        System.out.println(fireRecord);
    }

    //ACCESSOR METHODS (Note: I don't know if we need any of these ~ Lance)
    public ArrayList<String> getFireRecord() {
        return fireRecord;
    }

    public ArrayList<String> getFiringBoardHits() {
        return firingBoardHits;
    }

/*    public static void setFiringBoardHits(ArrayList<String> firingBoardHits) {
        FiringBoard.firingBoardHits = firingBoardHits;
    }*/

/*
    public ArrayList<String> getFiringBoardMisses() {
        return firingBoardMisses;
    }

    public void setFiringBoardMisses(ArrayList<String> firingBoardMisses) {
        this.firingBoardMisses = firingBoardMisses;
    }
*/

    public String gridAim() {
        return Player.guess;
    }
    //HELPERS
}