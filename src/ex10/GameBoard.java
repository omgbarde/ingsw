package ex10;

// Singleton Pattern: GameBoard
public class GameBoard {
    private static final GameBoard instance = new GameBoard();
    private static final GameLogic logic = new SimpleGameLogic();
    private static char[][] grid;

    private GameBoard() {
        grid = new char[3][3];
        // Initialize the grid with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public static GameBoard getInstance() {
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

    public void makeMove(int row, int col, char symbol) throws IllegalMoveException{
        // Update the grid with the player's move
        if(grid[row][col] == ' ' && row >= 0 && row < 3 && col >= 0 && col <3){
            grid[row][col] = symbol;
        }
        else{
            throw new IllegalMoveException();
        }
    }
}