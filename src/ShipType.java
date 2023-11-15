public enum ShipType {
    SUBMARINE("Submarine", 3),
    SMALL_BOAT("Small Boat", 2),
    DESTROYER("Destroyer", 3),
    AIRCRAFT_CARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4);

    private final String name; // ship name
    private final int size; // number of hits a ship can take before being sunk

    ShipType(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}