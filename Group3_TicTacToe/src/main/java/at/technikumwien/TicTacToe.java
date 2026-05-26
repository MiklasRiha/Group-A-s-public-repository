package at.technikumwien;

public class TicTacToe {

    Player player1;
    Player player2;
    Player currentPlayer;
    Board board;

    public TicTacToe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = this.player1;
        this.board = new Board();
    }

    // Starts the game and prints the title.
    public void start() {
        System.out.print("*** Tic Tac Toe *** \n");
    }

    // Switches the current player after a valid move.
    public void switchCurrentPlayer() {
        if (currentPlayer == this.player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
    }

    // Checks if the current player has won.
    public boolean hasWinner() {
        return this.board.hasWinner(this.currentPlayer.getMarker());
    }

    // Checks if the game ended in a draw.
    public boolean isDraw() {
        return this.board.isFull() && !hasWinner();
    }

    // Checks if the game is over because of a win or a draw.
    public boolean isGameOver() {
        return hasWinner() || isDraw();
    }

    // Prints the final game result.
    public void printGameEndNotification() {
        if (hasWinner()) {
            System.out.println("Player " + this.currentPlayer.getMarker() + " wins!");
        } else if (isDraw()) {
            System.out.println("The game ended in a draw!");
        }
    }
}