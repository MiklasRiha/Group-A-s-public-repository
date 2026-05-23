package at.technikumwien;


public class Main {
    public static void main(String[] args) {
        System.out.printf("*** Tic Tac Toe *** \n");
        startGame();


    }

    public static void startGame(){
        Board startBoard = new Board();
        startBoard.print();
    }

}