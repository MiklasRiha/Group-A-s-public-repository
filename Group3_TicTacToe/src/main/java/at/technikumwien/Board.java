package at.technikumwien;

public class Board {

    char[][] cells = new char[3][3];

    public Board() {
    }

    // Checks if a specific cell is still empty.
    public boolean isCellEmpty(int x, int y) {
        char cellContent = this.cells[x][y];

        if (cellContent == '\0') {
            return true;
        } else {
            return false;
        }
    }

    // Places the marker on the board if the selected cell is empty.
    public boolean place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            this.cells[x][y] = marker;
            return true;
        } else {
            System.out.println("Illegal move");
            return false;
        }
    }

    // Checks if all cells on the board are already filled.
    public boolean isFull() {
        for (int row = 0; row < this.cells.length; row++) {
            for (int col = 0; col < this.cells[row].length; col++) {
                if (this.cells[row][col] == '\0') {
                    return false;
                }
            }
        }

        return true;
    }

    // Checks if the given player marker has won the game.
    public boolean hasWinner(char marker) {
        return hasFullRow(marker) || hasFullColumn(marker) || hasFullDiagonal(marker);
    }

    // Checks all rows for three equal markers.
    private boolean hasFullRow(char marker) {
        for (int row = 0; row < this.cells.length; row++) {
            if (this.cells[row][0] == marker &&
                    this.cells[row][1] == marker &&
                    this.cells[row][2] == marker) {
                return true;
            }
        }

        return false;
    }

    // Checks all columns for three equal markers.
    private boolean hasFullColumn(char marker) {
        for (int col = 0; col < this.cells[0].length; col++) {
            if (this.cells[0][col] == marker &&
                    this.cells[1][col] == marker &&
                    this.cells[2][col] == marker) {
                return true;
            }
        }

        return false;
    }

    // Checks both diagonals for three equal markers.
    private boolean hasFullDiagonal(char marker) {
        boolean diagonalTopLeftToBottomRight =
                this.cells[0][0] == marker &&
                        this.cells[1][1] == marker &&
                        this.cells[2][2] == marker;

        boolean diagonalTopRightToBottomLeft =
                this.cells[0][2] == marker &&
                        this.cells[1][1] == marker &&
                        this.cells[2][0] == marker;

        return diagonalTopLeftToBottomRight || diagonalTopRightToBottomLeft;
    }

    // Prints the current board state to the console.
    public void print() {
        System.out.println("_______");

        for (int line = 0; line < this.cells.length; line++) {
            for (int i = 0; i < this.cells[line].length; i++) {
                System.out.print("|");
                System.out.print(this.cells[line][i]);
            }

            System.out.print("|");
            System.out.println();
        }

        System.out.println("-------");
    }
}