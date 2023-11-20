package com.battleship.boards;

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
        display();
        //System.out.println(fireRecord);
    }

    public void display(){
        char[][] board = boardThings();
        for (char[] chars : board) {
            System.out.println(chars);
        }
    }
    private char[][] boardThings(){
        char[][] board = {
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
        };

        if (fireRecord == null || fireRecord.isEmpty()){
            fireRecord = new ArrayList<>();
            firingBoardHits = new ArrayList<>();
        }

        for (String record : fireRecord){
            char row = record.charAt(0);
            char col = record.charAt(1);
            int rowInt = (row - 'a' +1) - 1;
            board[rowInt][col] = 'm';
        }
        for (String record : firingBoardHits){
            char row = record.charAt(0);
            char col = record.charAt(1);
            int rowInt = (row - 'a' +1) - 1;
            board[rowInt][col] = 'h';
        }
//        for (List<String> boat : shipBoard.getShipBoard()){
//            for (String b : boat) {
//                System.out.println(b);
//                char row = b.charAt(0);
//                char col = b.charAt(1);
//                int rowInt = (row - 'a' + 1);
//                System.out.println("row= " +rowInt+ "\ncol = "+col);
//                board[rowInt - 1][col] = 's';
//            }
//        }
        return board;
    }
}
