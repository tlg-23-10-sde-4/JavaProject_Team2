package com.game.battleship;

import java.io.FileReader;
import java.util.Scanner;

class Player {
    Scanner scanner = new Scanner(System.in);

    private String fleetName;


    //ctor
    public Player(){}

    public void fire(String row, int col){

    }

    public void placeShip(Ship ship, String row, int col, boolean horizontal){
        
    }

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

}