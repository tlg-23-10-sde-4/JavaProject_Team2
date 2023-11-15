package com.battleship.boards;

import java.util.HashMap;
class FiringBoard {


//FIELDS
    private HashMap<HashMap<String, Integer>, HashMap<String, Integer>> fireMap;

    private HashMap<String, Integer> firingBoardHits;

    private HashMap<String, Integer> firingBoardMisses;

    private String aimingVertical;
    private Integer aimingHorizontal;



    //maybe CTOR here?
//    public FiringBoard(HashMap<String, Integer> fireBoard) throws IllegalArgumentException {
//    }

    //METHODS
    public void fire() {
        //this will check shipBoard to see if the key and value that the user put in is equal to one from one of the boats
        //todo: make sure that it has the key AND the value in ONE ROW (paired)
        //todo: change "firingBoardHits" to the shipLocation map once built
        if (firingBoardHits.containsKey(getAimingVertical()) && firingBoardHits.containsValue(getAimingHorizontal())) {
            System.out.println("Your shell impacted an enemy ship!");
            firingBoardHits.put(getAimingVertical(), getAimingHorizontal());
        }
        else {
            System.out.println("Your shell impacted empty water!");
            firingBoardMisses.put(getAimingVertical(), getAimingHorizontal());
        }
    }

    //ACCESSOR METHODS
    //getters and setters for where the user wants to "fire" a round. that info will be put into the fire() method

    //to see ALL fires, misses and hits
    //TODO: make a graphic of some type to display this info (.toString of some kind?)
    public HashMap<String, Integer> getFiringBoard() {
        return firingBoardHits;
    }
    //to see just hits
    //TODO: make a graphic of some type to display this info
    public HashMap<String, Integer> getFiringBoardHits() {
        return firingBoardHits;
    }
    //to see just misses
    //TODO: make a graphic of some type to display this info
    public HashMap<String, Integer> getFiringBoardMisses() {
        return firingBoardMisses;
    }

    //aiming inputs start,
    //TODO: make sure that they can't try to fire "off the board"
    public String getAimingVertical() {
        return aimingVertical;
    }
    public void setAimingVertical(String aimingVertical) {
        this.aimingVertical = aimingVertical;
    }

    //TODO: make sure that they can't try to fire "off the board"
    public Integer getAimingHorizontal() {
        return aimingHorizontal;
    }

    public void setAimingHorizontal(Integer aimingHorizontal) {
        this.aimingHorizontal = aimingHorizontal;
    }
    //aiming input end
}