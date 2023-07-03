import ships.AircraftCarrier;
import ships.Battleship;
import ships.Ship;
import validity.Validation;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        GameBoard gameBoard = new GameBoard();
        gameBoard.printBoard();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells): ");
        String coordinates = scanner.nextLine().toUpperCase();
        CoordinateProcessing coordinateLetters = new CoordinateProcessing();
        int[] firstCoordinate = getCoordinate(coordinateLetters, coordinates, 0, 1);
        int[] lastCoordinate = getCoordinate(coordinateLetters, coordinates, 3, 4);

        Validation validation = new Validation();
        while (true) {
            if (!validation.isLocationValid(firstCoordinate, lastCoordinate)) {
                System.out.println("Error! Wrong location! Try again:");
            } else if (!validation.isLengthValid(firstCoordinate, lastCoordinate, Ship.AIRCRAFT_CARRIER.getSize())) {
                System.out.println("Error! Wrong length of the Aircraft Carrier! Try again:");
            } else if (!validation.isShipFarEnough(firstCoordinate, lastCoordinate, gameBoard)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else {
                break;
            }
            coordinates = scanner.nextLine().toUpperCase();
            firstCoordinate = getCoordinate(coordinateLetters, coordinates, 0, 1);
            lastCoordinate = getCoordinate(coordinateLetters, coordinates, 3, 4);
        }

        AircraftCarrier aircraftCarrier = new AircraftCarrier(firstCoordinate, lastCoordinate);
        gameBoard.addShip(aircraftCarrier, gameBoard.getBoard());
        gameBoard.printBoard();

        System.out.println("Enter the coordinates of the Battleship (4 cells): ");
        coordinates = scanner.nextLine().toUpperCase();
        firstCoordinate = getCoordinate(coordinateLetters, coordinates, 0, 1);
        lastCoordinate = getCoordinate(coordinateLetters, coordinates, 3, 4);

        while (true) {
            if (!validation.isLocationValid(firstCoordinate, lastCoordinate)) {
                System.out.println("Error! Wrong location! Try again:");
            } else if (!validation.isLengthValid(firstCoordinate, lastCoordinate, Ship.BATTLESHIP.getSize())) {
                System.out.println("Error! Wrong length of the Battleship! Try again:");
            } else if (!validation.isShipFarEnough(firstCoordinate, lastCoordinate, gameBoard)) {
                System.out.println("Error! You placed it too close to another one. Try again:");
            } else {
                break;
            }
            coordinates = scanner.nextLine().toUpperCase();
            firstCoordinate = getCoordinate(coordinateLetters, coordinates, 0, 1);
            lastCoordinate = getCoordinate(coordinateLetters, coordinates, 3, 4);
        }
        Battleship battleship = new Battleship(firstCoordinate, lastCoordinate);
        gameBoard.addShip(battleship, gameBoard.getBoard());
        gameBoard.printBoard();
    }

    private static int[] getCoordinate(CoordinateProcessing coordinateLetters, String coordinates, int index,
                                       int index1) {
        return new int[]{coordinateLetters.getCoordinateLetter(coordinates.charAt(index)),
                Integer.parseInt(String.valueOf(coordinates.charAt(index1))) - 1};
    }

}
