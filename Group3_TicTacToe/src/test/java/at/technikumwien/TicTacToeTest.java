package at.technikumwien;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    // --- switchCurrentPlayer() ---

    @Test
    void switchCurrentPlayer_fromPlayer1_returnsPlayer2() {
        // Player 1 (X) starts by default
        assertEquals('X', game.currentPlayer.getMarker());

        game.switchCurrentPlayer();

        assertEquals('O', game.currentPlayer.getMarker());
    }

    @Test
    void switchCurrentPlayer_fromPlayer2_returnsPlayer1() {
        game.switchCurrentPlayer(); // X -> O
        game.switchCurrentPlayer(); // O -> X

        assertEquals('X', game.currentPlayer.getMarker());
    }

    // --- hasWinner() ---

    @Test
    void hasWinner_returnsTrueWhenCurrentPlayerHasFullRow() {
        // Player X fills top row
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');

        assertTrue(game.hasWinner());
    }

    @Test
    void hasWinner_returnsFalseOnEmptyBoard() {
        assertFalse(game.hasWinner());
    }

    @Test
    void hasWinner_returnsFalseWhenOpponentHasFullRow() {
        // Player O fills top row, but current player is X
        game.board.place(0, 0, 'O');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'O');

        // currentPlayer is X — X has not won
        assertFalse(game.hasWinner());
    }

    // --- isDraw() ---

    @Test
    void isDraw_returnsTrueOnFullBoardWithNoWinner() {
        // Fill board without a winner:
        // X O X
        // X O X
        // O X O
        game.board.place(0, 0, 'X'); game.board.place(0, 1, 'O'); game.board.place(0, 2, 'X');
        game.board.place(1, 0, 'X'); game.board.place(1, 1, 'O'); game.board.place(1, 2, 'X');
        game.board.place(2, 0, 'O'); game.board.place(2, 1, 'X'); game.board.place(2, 2, 'O');

        assertTrue(game.isDraw());
    }

    @Test
    void isDraw_returnsFalseOnEmptyBoard() {
        assertFalse(game.isDraw());
    }

    @Test
    void isDraw_returnsFalseWhenBoardIsFullButWinnerExists() {
        // X wins with diagonal — board still gets filled
        game.board.place(0, 0, 'X'); game.board.place(0, 1, 'O'); game.board.place(0, 2, 'O');
        game.board.place(1, 0, 'O'); game.board.place(1, 1, 'X'); game.board.place(1, 2, 'O');
        game.board.place(2, 0, 'O'); game.board.place(2, 1, 'O'); game.board.place(2, 2, 'X');

        assertFalse(game.isDraw());
    }

    // --- isGameOver() ---

    @Test
    void isGameOver_returnsTrueWhenCurrentPlayerWins() {
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'X');
        game.board.place(0, 2, 'X');

        assertTrue(game.isGameOver());
    }

    @Test
    void isGameOver_returnsTrueOnDraw() {
        // Same draw board as isDraw test
        game.board.place(0, 0, 'X'); game.board.place(0, 1, 'O'); game.board.place(0, 2, 'X');
        game.board.place(1, 0, 'X'); game.board.place(1, 1, 'O'); game.board.place(1, 2, 'X');
        game.board.place(2, 0, 'O'); game.board.place(2, 1, 'X'); game.board.place(2, 2, 'O');

        assertTrue(game.isGameOver());
    }

    @Test
    void isGameOver_returnsFalseOnEmptyBoard() {
        assertFalse(game.isGameOver());
    }

    // --- start() ---

    @Test
    void start_doesNotThrowException() {
        assertDoesNotThrow(() -> game.start());
    }

    @Test
    void start_initialPlayerIsX() {
        game.start();
        assertEquals('X', game.currentPlayer.getMarker());
    }
}