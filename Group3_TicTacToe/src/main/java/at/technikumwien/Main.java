package at.technikumwien;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("*** Tic Tac Toe *** \n");

        Board board = new Board();
        Player player1 = new Player('X');
        Player player2 = new Player('O');

        System.out.println(player1.getMarker());

        System.out.println();
        System.out.printf("Current Player: %c\n", player1.getMarker());
        board.print();

        System.out.println("row (0-2): ");
        int inputRow = sc.nextInt();
        System.out.println("col (0-2): ");
        int inputCol = sc.nextInt();

        board.place(inputRow, inputCol, player1.getMarker());
        board.print();


    }

    public static void startGame(){
        Board startBoard = new Board();
        startBoard.print();
    }

}