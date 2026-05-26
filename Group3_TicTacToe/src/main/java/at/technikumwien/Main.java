package at.technikumwien;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {

        // game initialize - newGame holds player and board data
        TicTacToe newGame = new TicTacToe();
        newGame.player1 = new Player('X');
        newGame.player2 = new Player('O');
        newGame.board = new Board();

        // print msg
        newGame.start();

        // game loop - place holder - 9 possible moves in total - has to be updated to
        int turnCounter = 0;

        while (turnCounter <= 9){
            System.out.println("Current Player: " + newGame.currentPlayer.getMarker());
            newGame.board.print();

            boolean legalMove;
            do {
                System.out.println("row (0-2): ");
                int rowInput = sc.nextInt();    // no wrong Input check
                System.out.println("col (0-2): ");
                int colInput = sc.nextInt();    // no wrong Input check
                legalMove = newGame.board.place(rowInput, colInput, newGame.currentPlayer.getMarker());
            } while(!legalMove);


            newGame.switchCurrentPlayer();
            turnCounter++;
        }

            System.out.println("Game ended.");
            System.out.println("Do you want to start a new game? (y/n)");

            String answer = sc.next();

            if (answer.equalsIgnoreCase("y")) {
                playAgain = true;
            } else {
                playAgain = false;
            }

        }

        System.out.println("Thanks for playing!");
        sc.close();
    }
}