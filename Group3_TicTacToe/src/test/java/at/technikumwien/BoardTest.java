package at.technikumwien;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void US01_placeMarkerOnEmptySquare() {
        Board board = new Board();
        board.place(0, 0, 'X');
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
        board.place(0,0,'X');
        board.place(0,0,'O');
        assertEquals('X', board.cells[0][0]);
    }

    @Test
    void US02_boardReflectsPlacedMarker() {
        Board board = new Board();
        board.place(1,1, 'X');
        assertEquals('X', board.cells[1][1]);
    }

    @Test
    void US02_boardIsEmptyAtStart() {
        Board board = new Board();
        for (int i = 0; i < board.cells.length; i++){
            for (int j = 0; j < board.cells[i].length; j++){
                assertTrue(board.isCellEmpty(i,j));
                assertEquals('\0', board.cells[i][j]);
            }
        }
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
    @Test
    void hasWinnerReturnsTrueForFullColumn() {
        Board board = new Board();

        board.place(0, 1, 'O');
        board.place(1, 1, 'O');
        board.place(2, 1, 'O');

        assertTrue(board.hasWinner('O'));
    }

    @Test
    void hasWinnerReturnsFalseWhenMarkerHasNoWinningLine() {
        Board board = new Board();

        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(1, 1, 'X');

        assertFalse(board.hasWinner('X'));
    }

    @Test
    void hasWinnerReturnsTrueForFullDiagonal() {
        Board board = new Board();

        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');

        assertTrue(board.hasWinner('X'));
    }
}
