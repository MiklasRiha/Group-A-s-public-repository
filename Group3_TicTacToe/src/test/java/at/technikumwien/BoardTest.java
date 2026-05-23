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
}