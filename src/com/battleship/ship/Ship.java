package com.battleship.ship;

class Ship {
    private ShipType type;
    private int hits;

    public Ship(ShipType type) {
        this.type = type;
        this.hits = 0;
    }

    boolean hit() { // 'hit' represents a hit on the ship
        hits++;
        return hits == type.getSize(); // checks to see if the com.battleship.ship.ShipType is hit equal to its size(hits allowed),
                                       // true = sunk, false = not sunk
    }

    // TODO: call to firingBoard, shipBoard
}