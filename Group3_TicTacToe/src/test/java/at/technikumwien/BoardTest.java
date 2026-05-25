package at.technikumwien;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void US01_placeMarkerOnEmptySquare() {
        Board board = new Board();

        board.place(0, 0, 'X');

        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void isCellEmptyReturnsTrueForEmptyCell() {
        Board board = new Board();

        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void isCellEmptyReturnsFalseForOccupiedCell() {
        Board board = new Board();

        board.place(0, 0, 'X');

        assertFalse(board.isCellEmpty(0, 0));
    }

    @Test
    void US01_cannotPlaceOnOccupiedPlace() {
        Board board = new Board();

        board.place(0, 0, 'X');
        board.place(0, 0, 'O');

        assertEquals('X', board.cells[0][0]);
    }

    @Test
    void placeStoresMarkerInSelectedCell() {
        Board board = new Board();

        board.place(1, 1, 'O');

        assertFalse(board.isCellEmpty(1, 1));
    }

    @Test
    void placeThrowsExceptionForInvalidPosition() {
        Board board = new Board();

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> board.place(3, 0, 'X'));
    }

    @Test
    void isFullReturnsFalseForNewBoard() {
        Board board = new Board();

        assertFalse(board.isFull());
    }

    @Test
    void isFullReturnsTrueWhenAllCellsAreFilled() {
        Board board = new Board();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board.place(row, col, 'X');
            }
        }

        assertTrue(board.isFull());
    }
}