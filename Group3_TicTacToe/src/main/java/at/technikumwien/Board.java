package at.technikumwien;

public class Board {

    char[][] cells = new char[3][3];

    // Constructor
    public Board(){

    }


    // Methods
    public boolean isCellEmpty(int x, int y){
        char cellContent = cells[x][y];

        if (cellContent == '\0'){
            return true;
        } else {
            return false;
        }
    }

    public void place (int x, int y, char marker){
        char cellPosition = cells[x][y];
        cellPosition = marker;
    }

    public boolean isFull() {
        for (int row = 0; row < cells[row].length; row++) {
            for (int col = 0; col < cells.length; col++) {
                if (cells[row][col] == '\0') {
                    return false;
                }
            }
        }
        return true;
    }

    public void print(){
        System.out.println("_______");

        for (int line = 0; line < cells.length; line++){
            for (int i = 0; i < cells[line].length; i++){
                System.out.print("|");
                System.out.print(cells[line][i]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("-------");

    }
}
