package ticTacToe;



public class TicTacToe {
	public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.displayWelcomeMessage();
        game.startGame();
	}
    private char[][] grid;
    private int rowNumber;
    private int columnNumber;
    private char currentPlayer;

    public TicTacToe() {
        grid = new char[3][3];
        initializeGrid();
        currentPlayer = 'X';
    }

    private void initializeGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Tic-Tac-Toe!\n");
    }

    public void displayGrid() {
        System.out.println("Current grid:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) 
                System.out.println("----------");
            }
        }
    

    public void startGame() {
        boolean gameWon = false;
        int moves = 0;
        while (!gameWon && moves < 9) {
            displayGrid();
            takeTurn();
            gameWon = checkForWinner();
            moves++;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        displayGrid(); // Display grid at the end of game
        if (gameWon) {
            System.out.println("\nPlayer " + (currentPlayer == 'X' ? 'O' : 'X') + " wins!");
        } else {
            System.out.println("\nThe game is a draw!");
        }
    }

    public void takeTurn() {
        boolean validInput = false;
        while (!validInput) {
            System.out.println("\n" + currentPlayer + "'s turn \n" + "Pick a row (0, 1, 2): ");
            rowNumber = getUserInput();
            System.out.println("Pick a column (0, 1, 2): ");
            columnNumber = getUserInput();

            if (rowNumber >= 0 && rowNumber < 3 && columnNumber >= 0 && columnNumber < 3 && grid[rowNumber][columnNumber] == ' ') {
                grid[rowNumber][columnNumber] = currentPlayer;
                validInput = true;
            } else {
                System.out.println("\nInvalid move, try again.\n");
            }
        }
    }

    private int getUserInput() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        return scanner.nextInt();
    }

    public boolean checkForWinner() {
        // row and column check
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0] == currentPlayer && grid[i][1] == currentPlayer && grid[i][2] == currentPlayer) ||
                (grid[0][i] == currentPlayer && grid[1][i] == currentPlayer && grid[2][i] == currentPlayer)) {
                return true;
            }
        }
        // check to see if diagonal win
        if ((grid[0][0] == currentPlayer && grid[1][1] == currentPlayer && grid[2][2] == currentPlayer) ||
            (grid[0][2] == currentPlayer && grid[1][1] == currentPlayer && grid[2][0] == currentPlayer)) {
            return true;
        }
        return false;
    }
}
