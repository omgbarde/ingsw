package ex10;

// Factory Method Pattern: Player
public abstract class Player {
    protected static char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public static char getSymbol() {
        return symbol;
    }

    public abstract void makeMove();
}