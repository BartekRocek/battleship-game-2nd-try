package validity;

public class Validation {


    public boolean isLengthValid(int[] firstCoordinate, int[] lastCoordinate, int length) {
        return (firstCoordinate[0] == lastCoordinate[0] && Math.abs(firstCoordinate[1] - lastCoordinate[1]) == length - 1)
                || (firstCoordinate[1] == lastCoordinate[1] && Math.abs(firstCoordinate[0] - lastCoordinate[0]) == length - 1);
    }

    public boolean isLocationValid(int[] firstCoordinate, int[] lastCoordinate) {
        return (firstCoordinate[0] == lastCoordinate[0] || firstCoordinate[1] == lastCoordinate[1]);
    }

    public boolean isShipFarEnough(int[] firstCoordinate, int[] lastCoordinate, GameBoard gameboard) {
        for (int i = firstCoordinate[0]; i <= lastCoordinate[0]; i++) {
            for (int j = firstCoordinate[1]; j <= lastCoordinate[1]; j++) {
                // Check if the cell is already occupied
                if (gameboard.getBoard()[i][j].equals("O")) {
                    return false;
                }
                // Check adjacent cells
                if (i > 0 && gameboard.getBoard()[i - 1][j].equals("O")) {
                    return false;
                }
                if (i < gameboard.getBoard().length - 1 && gameboard.getBoard()[i + 1][j].equals("O")) {
                    return false;
                }
                if (j > 0 && gameboard.getBoard()[i][j - 1].equals("O")) {
                    return false;
                }
                if (j < gameboard.getBoard()[i].length - 1 && gameboard.getBoard()[i][j + 1].equals("O")) {
                    return false;
                }
            }
        }
        return true;

    }

}
