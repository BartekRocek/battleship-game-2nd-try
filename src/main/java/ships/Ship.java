package ships;

public enum Ship {
    AIRCRAFT_CARRIER(5),
    BATTLESHIP(4),
    SUBMARINE(3),
    CRUISER(3),
    DESTROYER(2);

    private final int size;

    Ship(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}
