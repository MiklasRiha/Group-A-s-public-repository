package at.technikumwien;

public class TicTacToe {

    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    public TicTacToe(){

    }

    public void start(){
        System.out.print("*** Tic Tac Toe *** \n");
        this.currentPlayer = this.player1;
    }

    public void switchCurrentPlayer(){
        if (currentPlayer == this.player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    public boolean hasWinner(){
        return true;
    }
}
