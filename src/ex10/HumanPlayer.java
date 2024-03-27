package ex10;

import java.util.Scanner;

// Factory Method Pattern: HumanPlayer
public class HumanPlayer extends Player {
    private final Scanner scanner = new Scanner(System.in);
    private TicTacToeClient client;

    public HumanPlayer(char symbol, TicTacToeClient client) {
        super(symbol);
        this.client = client;
    }

    @Override
    public synchronized void makeMove() {
        int row, col;
        GameBoard board = GameBoard.getInstance();
        //System.out.println(getSymbol() + ": provo a giocare nel turno di "+ board.getCurrentTurn());
        if (getSymbol() == board.getCurrentTurn()) {
            try {
                GameBoard.displayBoard();
                System.out.println("Enter the row (0, 1, or 2): ");
                row = scanner.nextInt();
                System.out.println("Enter the column (0, 1, or 2): ");
                col = scanner.nextInt();

                client.sendMessage("MOVE " + row + " " + col);

                // Update the game board with the move
                // Assuming there is a method like makeMove(row, col) in the game board
                // You need to adapt this part based on your actual implementation
                try {
                    board.makeMove(row, col, symbol);
                    if (board.getLogic().checkWin(board.getGrid(), Player.getSymbol())) {
                        client.sendMessage("VINCE " + Player.getSymbol());
                        return;
                    }
                    if (board.getLogic().checkDraw(board.getGrid())) {
                        client.sendMessage("PAREGGIO");
                        return;
                    }
                    client.sendMessage("turno di " + board.getCurrentTurn());

                } catch (IllegalMoveException e) {
                    System.out.println("illegal move");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter valid integers for row and column.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        else{
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}