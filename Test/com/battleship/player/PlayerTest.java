package com.battleship.player;

import com.battleship.boards.ShipBoard;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

class PlayerTest {

    public static void main(String[] args) {
        ShipBoard shipBoard = new ShipBoard();
        Player p1 = new Player();
        //p1.placeShips(shipBoard);
        //System.out.println(ShipBoard.getShipBoard());
        p1.takeTurn();
    }}

/*
    @Test
    public void battleShip_shouldRejectString_whenStringFormatInvalid() {
        Player p1 = new Player();

    }
}*/
