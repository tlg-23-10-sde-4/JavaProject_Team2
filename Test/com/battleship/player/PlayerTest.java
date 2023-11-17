package com.battleship.player;

import com.battleship.boards.ShipBoard;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

class PlayerTest {

    public static void main(String[] args) {
        Player p1 = new Player();
        p1.placeShips();
        System.out.println(ShipBoard.getShipBoard());
    }

    @Test
    public void battleShip_shouldRejectString_whenStringFormatInvalid() {
        Player p1 = new Player();

    }
}