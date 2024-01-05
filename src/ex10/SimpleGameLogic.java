package ex10;

// Strategy Pattern: SimpleGameLogic
public class SimpleGameLogic implements GameLogic {
    @Override
    public boolean checkWin(char[][] grid, char symbol) {
        // Implement simple win-checking logic
        for(int i = 0; i < 3; i++){
            if(grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) return true;
        }
        for(int i = 0; i < 3; i++){
            if(grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol) return true;
        }
        if(grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) return true;
        if(grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol) return true;

        return false;
    }

    @Override
    public boolean checkDraw(char[][] grid) {
        // Implement simple draw-checking logic
        for( int i = 0; i < 2; i++){
            for(int j = 0; j<2; j++){
                if (grid[i][j] == ' ') return false;
            }
        }
        return true;
    }
}