
import java.util.Scanner;

public class nqueen {

    static int board[][];
    static int n;
    static int fixedRow, fixedCol;

    // Print chessboard
    static void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check whether position is safe
    static boolean isSafe(int row, int col) {

        // Check column
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check row
        for (int j = 0; j < n; j++) {
            if (board[row][j] == 1)
                return false;
        }

        // Check diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 1) {
                    if (Math.abs(row - i) ==
                        Math.abs(col - j))
                        return false;
                }
            }
        }

        return true;
    }

    // Solve using backtracking
    static boolean solve(int row) {

        if (row == n)
            return true;

        // Skip row containing fixed queen
        if (row == fixedRow)
            return solve(row + 1);

        for (int col = 0; col < n; col++) {

            if (isSafe(row, col)) {

                board[row][col] = 1;

                System.out.println("Queen placed at (" +
                    (row + 1) + "," + (col + 1) + ")");
                printBoard();

                if (solve(row + 1))
                    return true;

                board[row][col] = 0;

                System.out.println("Backtracking: Queen removed from (" +
                    (row + 1) + "," + (col + 1) + ")");
                printBoard();
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid N!");
            sc.close();
            return;
        }

        board = new int[n][n];

        System.out.print("Enter fixed queen row: ");
        fixedRow = sc.nextInt() - 1;

        System.out.print("Enter fixed queen column: ");
        fixedCol = sc.nextInt() - 1;

        if (fixedRow < 0 || fixedRow >= n ||
            fixedCol < 0 || fixedCol >= n) {
            System.out.println("Invalid position!");
            sc.close();
            return;
        }

        // Place first queen
        board[fixedRow][fixedCol] = 1;

        System.out.println("First queen placed:");
        printBoard();

        if (solve(0)) {
            System.out.println("Final Solution:");
            printBoard();
        } else {
            System.out.println("No solution possible!");
        }

        sc.close();
    }
}

/*
Approach: Backtracking

Time Complexity: O(N! * N^2) 
Space Complexity: O(N^2)

Explanation:
- Places N queens on an N x N chessboard.
- No two queens should attack each other.
- Checks whether a position is safe before placing a queen.
- If no valid position is found, removes the previously
  placed queen and tries another position.
- Uses recursion to place the remaining queens.
Why?
- Queens are placed row by row.
- Each row tries different column positions.
- The number of possible arrangements is bounded
  by N! because only one queen can be placed in each row
  and each column.
- The isSafe() function scans the board and takes O(N^2).
- Therefore, a conservative upper bound is O(N! * N^2).
- The N x N chessboard requires O(N^2) space.
- Recursion requires O(N) additional stack space,
  which is smaller than O(N^2).

Where:
N = Size of the chessboard.

Objective:
To place N queens safely on an N x N chessboard.

Note:
The first queen is already placed at the position
provided by the user.
*/