import java.io.FileReader;
import java.util.Scanner;

class Player {

    private String fleetName;
    private ShipType ship;
    private String guessX;
    private int guessY;
    private boolean isHorizontal;
    private String shipX;
    private int shipY;

    //ctor
    public Player(){}

    public String getFleetName() {
        return fleetName;
    }

    public void setFleetName(String fleetName) {
        this.fleetName = fleetName;
    }

    public ShipType getShip() {
        return ship;
    }

    public void setShip(ShipType ship) {
        this.ship = ship;
    }

    public String getGuessX() {
        return guessX;
    }

    public int getGuessY() {
        return guessY;
    }

    public boolean getIsHorizontal() {
        return isHorizontal;
    }

    public String getShipX() {
        return shipX;
    }

    public int getShipY() {
        return shipY;
    }
}