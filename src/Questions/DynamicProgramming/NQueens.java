package Questions.DynamicProgramming;

public class NQueens {

    static int N = 4;

    void printSolution(int sol[][]) {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }

            System.out.println();
        }
    }

    boolean isSafe(int row, int col, int board[][]) {

        int i, j;

        for (i = row; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (i = row, j = col; i < N && j >= 0; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    boolean solveNQ() {

        int[][] board = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        if (solveNQUtil(board, 0) == false) {
            System.out.println("Solution doesn't exist");
            return false;
        }

        printSolution(board);
        return true;
    }

    private boolean solveNQUtil(int[][] board, int col) {

        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {

            if (isSafe(i, col, board)) {

                board[i][col] = 1;

                if (solveNQUtil(board, col + 1))
                    return true;

                board[i][col] = 0;
            }
        }
        return false;
    }
}
