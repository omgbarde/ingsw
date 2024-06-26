package ex10;

// Singleton Pattern: GameBoard
public class GameBoard {
    private static GameBoard instance = new GameBoard();
    //game logic can be changed
    private static GameLogic logic = new SimpleGameLogic();
    private static char[][] grid;
    //X always starts
    private static char currentTurn = 'X';

    private GameBoard() {
        grid = new char[3][3];
        // Initialize the grid with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public synchronized static GameBoard getInstance() {
        return instance;
    }

    public static void displayBoard() {
        // Display the current state of the board
        // (You can customize the format based on your preference)
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public char[][] getGrid() {
        return grid;
    }

    public static GameLogic getLogic() {
        return logic;
    }

    public synchronized void makeMove(int row, int col, char symbol) throws IllegalMoveException{
        // Update the grid with the player's move
        if(grid[row][col] == ' ' && row >= 0 && row < 3 && col >= 0 && col <3){
            placeSymbol(symbol,row,col);
            if(currentTurn == 'X') setTurn('O') ;
            else setTurn('X');
            displayBoard();
            notify();
        }
        else{
            throw new IllegalMoveException();
        }
    }

    public synchronized char getCurrentTurn(){
        return currentTurn;
    }

    private synchronized void setTurn(char t){
        currentTurn = t;
    }
    private void placeSymbol(char s, int i, int j){
        grid[i][j] = s;
    }
}