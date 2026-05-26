package at.technikumwien;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TicTacToe newGame = new TicTacToe();

        newGame.start();

        // The game continues until there is a winner or a draw.
        while (!newGame.isGameOver()) {
            System.out.println("Current Player: " + newGame.currentPlayer.getMarker());
            newGame.board.print();

            boolean legalMove;

            // Repeats the input until the player chooses a valid and empty cell.
            do {
                int rowInput = readValidNumber(sc, "row (0-2): ");
                int colInput = readValidNumber(sc, "col (0-2): ");

                legalMove = newGame.board.place(rowInput, colInput, newGame.currentPlayer.getMarker());

                if (!legalMove) {
                    System.out.println("This cell is already occupied. Please choose another cell.");
                }

            } while (!legalMove);

            // After every valid move, the game checks if it has ended.
            if (newGame.isGameOver()) {
                newGame.board.print();
                newGame.printGameEndNotification();
            } else {
                newGame.switchCurrentPlayer();
            }
        }

        sc.close();
    }

    // Reads a number from the user and checks if it is between 0 and 2.
    private static int readValidNumber(Scanner sc, String message) {
        int input;

        while (true) {
            System.out.println(message);

            if (sc.hasNextInt()) {
                input = sc.nextInt();

                if (input >= 0 && input <= 2) {
                    return input;
                } else {
                    System.out.println("Invalid input. Please enter a number between 0 and 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
            }
        }
    }
}