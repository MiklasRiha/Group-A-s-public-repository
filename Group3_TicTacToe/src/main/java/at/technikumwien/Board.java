package at.technikumwien;

public class Board {

    char[][] cells = new char[3][3];

    // Constructor
    public Board(){

    }

    // Methods Class Diagram
    public boolean isCellEmpty(int x, int y){
        char cellContent = this.cells[x][y];

        if (cellContent == '\0'){
            return true;
        } else {
            return false;
        }
    }

    public void place (int x, int y, char marker){
        this.cells[x][y] = marker;
    }

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

    public void print(){
        System.out.println("_______");

        for (int line = 0; line < this.cells.length; line++){
            for (int i = 0; i < this.cells[line].length; i++){
                System.out.print("|");
                System.out.print(this.cells[line][i]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-------");

    }
}
