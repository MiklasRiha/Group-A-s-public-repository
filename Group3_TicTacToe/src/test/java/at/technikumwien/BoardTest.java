package at.technikumwien;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void US01_placeMarkerOnEmptySquare() {
        Board board = new Board();
        board.place(0,0,'X');
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



}