package ships;

public class Battleship implements Vessel {

    private int[][] coordinates;
    private static final int SIZE = Ship.BATTLESHIP.getSize(); // 4

    public Battleship(int[] firstCoordinate, int[] lastCoordinate) {
        int x1 = firstCoordinate[0];
        int y1 = firstCoordinate[1];
        int x2 = lastCoordinate[0];
        int y2 = lastCoordinate[1];

        if (x1 == x2) {
            //same row
            coordinates = new int[SIZE][2];
            for (int i = 0; i < SIZE; i++) {
                coordinates[i][0] = x1;
                coordinates[i][1] = y1 + i;
            }
        } else if (y1 == y2) {
            coordinates = new int[SIZE][2];
            for (int i = 0; i < SIZE; i++) {
                coordinates[i][0] = x1 + i;
                coordinates[i][1] = y1;
            }
        }
    }

    @Override
    public int[][] getCoordinates() {
        return coordinates;
    }
}
