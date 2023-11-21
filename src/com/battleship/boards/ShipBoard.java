package com.battleship.boards;

import java.util.ArrayList;
import java.util.List;

public class ShipBoard {
    private List<List<String>> shipBoard;

    public void placeShip(List<String> location) {
            if (shipBoard == null) {
                shipBoard = new ArrayList<>();
            }
            shipBoard.add(location);
        }

    // check to see if ship is sunk
    public boolean sink() {
        boolean result = false;
        for (List<String> boat : shipBoard) {
            if (boat.isEmpty()) {
                shipBoard.remove(boat);
                result = true;
                break;
            }
        }
        return result;
    }

    // checks for overlapping ship placement
    public boolean isValidPlacement(List<String> location) {
        boolean result = false;
        if (shipBoard== null) {
            shipBoard = new ArrayList<>();
            result = true;
        }
        for (List<String> shipList : shipBoard) {
            for (String ship : shipList){
                if (!location.contains(ship)) {
                    result = true;
                }

                else {
                    System.out.println("One of the coordinates is intersecting with another ship, please try again.");
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    // prints current state of ShipBoard
    public void printShipBoard(FiringBoard firingBoard) {
        char[][] board = displayShipBoard(firingBoard);
        for (char[] chars : board) {
            List<String> tempBoardList = new ArrayList<>();
            for (char c : chars){
                tempBoardList.add(color(c));
            }
            System.out.println(tempBoardList);
        }
    }

    // displays new ShipBoard
    private char[][] displayShipBoard(FiringBoard firingBoard) {
        char[][] board = {
                {'*', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',},
                {'a', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'b', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'c', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'d', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'e', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'f', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'g', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'h', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'i', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {'j', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
        };

        if (shipBoard != null) {
            for (List<String> boat : shipBoard) {
                for (String b : boat) {
                    char row = b.charAt(0);
                    char col = b.charAt(1);
                    int colInt = (col - '1') + 1;
                    int rowInt = (row - 'a' + 1);
                    board[rowInt][colInt + 1] = 'S';
                }
            }
        }
        if (firingBoard.getFiringBoardHits() != null) {
            for (String record : firingBoard.getFiringBoardHits()) {
                char row = record.charAt(0);
                char col = record.charAt(1);
                int colInt = (col - '1') + 1;
                int rowInt = (row - 'a' + 1);
                board[rowInt][colInt + 1] = 'X';
            }
        }
        return board;
    }

    // changes font color for board
    private String color(char grid) {
        String resetColor = "\u001B[0m";
        String red = "\u001B[31m";
        String blue = "\u001B[36m";
        String gray = "\u001B[90m";

        switch (grid) {
            case '-':
                return blue + grid + resetColor;
            case 'X':
                return red + grid + resetColor;
            case 'S':
                return gray + grid +resetColor;
            default:
                String var = String.valueOf(grid);
                return var;
        }
    }

    // check to see if any ships remaining
    public boolean allShipsSunk() {
        boolean result = false;
        if (shipBoard == null || shipBoard.size() == 0) {
            result = true;
        }
        return result;
    }

    public List<List<String>> getShipBoard() {
        return shipBoard;
    }
}