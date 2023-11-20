package com.battleship.boards;

import com.battleship.player.Player;

import java.util.ArrayList;
import java.util.List;

public class FiringBoard {

//FIELDS
    private List<String> fireRecord;

    private List<String> firingBoardHits;

    private ShipBoard shipBoard;

    private String aiming;

    public FiringBoard(ShipBoard shipBoard) {
        this.shipBoard = shipBoard;
    }

    //METHODS
    public void fire(String aim) {
        if (fireRecord == null) {
            firingBoardHits = new ArrayList<>();
            fireRecord = new ArrayList<>();
            fireRecord.add(aim);
            impact(aim);
        }
        else {
            for (String shot : fireRecord) {
                if (aim.equals(shot)) {
                    System.out.println("That grid has already been hit!");
                    break;
                } else {
                    fireRecord.add(aim);
                    impact(aim);
                    break;
                }
            }
        }
    }
    // TODO implement false message
    public boolean impact(String aim) {
        boolean result = false;
        for (List<String> boat : shipBoard.getShipBoard()){

            for (String b : boat) {
                if (b.equals(aim)) {
                    firingBoardHits.add("X-" + aim);
                    System.out.println("That round hit a ship! " + aim);
                    hit(aim);
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

    private void hit(String guess) {
        for (List<String> boat : shipBoard.getShipBoard()){
            boat.remove(guess);
        }
    }

    public void printBoard() {
        System.out.println(fireRecord);
    }
}