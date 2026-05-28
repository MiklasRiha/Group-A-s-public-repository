package at.technikumwien;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void hasWinnerReturnsTrueWhenCurrentPlayerHasFullRow() {
        TicTacToe game = new TicTacToe();

        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');

        assertTrue(game.hasWinner());
    }

    @Test
    void hasWinnerReturnsFalseWhenCurrentPlayerHasNoFullRowColumnOrDiagonal() {
        TicTacToe game = new TicTacToe();

        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');

        assertFalse(game.hasWinner());
    }

    @Test
    void isDrawReturnsTrueWhenBoardIsFullAndThereIsNoWinner() {
        TicTacToe game = new TicTacToe();

        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');

        game.board.place(1, 0, 'X');
        game.board.place(1, 1, 'O');
        game.board.place(1, 2, 'O');

        game.board.place(2, 0, 'O');
        game.board.place(2, 1, 'X');
        game.board.place(2, 2, 'X');

        assertTrue(game.isDraw());
    }

    @Test
    void isDrawReturnsFalseWhenBoardIsNotFull() {
        TicTacToe game = new TicTacToe();

        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');

        assertFalse(game.isDraw());
    }

    @Test
    void isGameOverReturnsTrueWhenCurrentPlayerHasWinner() {
        TicTacToe game = new TicTacToe();

        game.board.place(0, 0, 'X');
        game.board.place(1, 1, 'X');
        game.board.place(2, 2, 'X');

        assertTrue(game.isGameOver());
    }

    @Test
    void isGameOverReturnsFalseWhenThereIsNoWinnerAndBoardIsNotFull() {
        TicTacToe game = new TicTacToe();

        game.board.place(0, 0, 'X');
        game.board.place(1, 1, 'O');

        assertFalse(game.isGameOver());
    }

    @Test
    void printGameEndNotificationPrintsWinnerMessage() {
        TicTacToe game = new TicTacToe();

        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        game.printGameEndNotification();

        System.setOut(System.out);

        assertTrue(output.toString().contains("Player X wins!"));
    }

    @Test
    void printGameEndNotificationPrintsDrawMessage() {
        TicTacToe game = new TicTacToe();

        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');

        game.board.place(1, 0, 'X');
        game.board.place(1, 1, 'O');
        game.board.place(1, 2, 'O');

        game.board.place(2, 0, 'O');
        game.board.place(2, 1, 'X');
        game.board.place(2, 2, 'X');

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        game.printGameEndNotification();

        System.setOut(System.out);

        assertTrue(output.toString().contains("The game ended in a draw!"));
    }
}