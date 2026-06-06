import java.util.Scanner;

public class Connect_game{
    private static final int ROWS = 6;
    private static final int COLS = 7;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private char[][] board = new char[ROWS][COLS];

    public Connect_game() {
        // Initialize board with empty slots
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        for (int j = 0; j < COLS; j++) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public boolean dropDisc(int col, char player) {
        if (col < 0 || col >= COLS) return false;
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col] == EMPTY) {
                board[i][col] = player;
                return true;
            }
        }
        return false; // Column full
    }

    public boolean checkWin(char player) {
        // Horizontal check
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j <= COLS - 4; j++) {
                if (board[i][j] == player && board[i][j+1] == player &&
                    board[i][j+2] == player && board[i][j+3] == player) {
                    return true;
                }
            }
        }
        // Vertical check
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == player && board[i+1][j] == player &&
                    board[i+2][j] == player && board[i+3][j] == player) {
                    return true;
                }
            }
        }
        // Diagonal (down-right)
        for (int i = 0; i <= ROWS - 4; i++) {
            for (int j = 0; j <= COLS - 4; j++) {
                if (board[i][j] == player && board[i+1][j+1] == player &&
                    board[i+2][j+2] == player && board[i+3][j+3] == player) {
                    return true;
                }
            }
        }
        // Diagonal (up-right)
        for (int i = 3; i < ROWS; i++) {
            for (int j = 0; j <= COLS - 4; j++) {
                if (board[i][j] == player && board[i-1][j+1] == player &&
                    board[i-2][j+2] == player && board[i-3][j+3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFull() {
        for (int j = 0; j < COLS; j++) {
            if (board[0][j] == EMPTY) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connect_game game = new Connect_game();
        char currentPlayer = PLAYER_X;

        while (true) {
            game.printBoard();
            System.out.println("Player " + currentPlayer + ", choose a column (0-6): ");
            int col = sc.nextInt();

            if (!game.dropDisc(col, currentPlayer)) {
                System.out.println("Column full or invalid. Try again.");
                continue;
            }

            if (game.checkWin(currentPlayer)) {
                game.printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (game.isFull()) {
                game.printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
        }
        sc.close();
    }
}

