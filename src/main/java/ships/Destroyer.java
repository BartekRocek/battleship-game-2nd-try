package ships;

public class Destroyer implements Vessel {

    private int[][] coordinates;
    private static final int SIZE = Ship.DESTROYER.getSize(); // 2

    public Destroyer(int[] firstCoordinate, int[] lastCoordinate) {
        int x1 = firstCoordinate[0];
        int y1 = firstCoordinate[1];
        int x2 = lastCoordinate[0];
        int y2 = lastCoordinate[1];

        if (x1 == x2) {
            // same row
//            int SIZE = Math.abs(y2 - y1) + 1;
            coordinates = new int[SIZE][2];
            for (int i = 0; i < SIZE; i++) {
                coordinates[i][0] = x1;
                coordinates[i][1] = y1 + i;
            }
        } else if (y1 == y2) {
            // same column
//            int SIZE = Math.abs(x2 - x1) + 1;
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
