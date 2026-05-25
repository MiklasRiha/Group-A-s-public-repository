package at.technikumwien;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getMarkerReturnsXMarker() {
        Player player = new Player('X');

        assertEquals('X', player.getMarker());
    }

    @Test
    void getMarkerReturnsOMarker() {
        Player player = new Player('O');

        assertEquals('O', player.getMarker());
    }

    @Test
    void getMarkerDoesNotReturnWrongMarker() {
        Player player = new Player('X');

        assertNotEquals('O', player.getMarker());
    }
}