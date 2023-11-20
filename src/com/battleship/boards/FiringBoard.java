package com.battleship.boards;

import com.battleship.player.Player;

import java.util.ArrayList;

public class FiringBoard {

//FIELDS
    private ArrayList<String> fireRecord;

    private ArrayList<String> firingBoardHits;


    private String aiming;

    //METHODS
    public void fire(String aim, ShipBoard shipBoard) {
        if (fireRecord == null) {
            firingBoardHits = new ArrayList<>();
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
    // TODO implement false message
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

                } else {
                    fireRecord.add("O" + aim);
                    System.out.println("That round hit water. " + aim);
                    result = false;
                    break;
                }
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
}