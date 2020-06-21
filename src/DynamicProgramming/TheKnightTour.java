package DynamicProgramming;

public class TheKnightTour {
    static int N = 8;

    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    static void printSolution(int sol[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean SolveKnightTour() {
        int sol[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }

        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        sol[0][0] = 0;

        if (!SolveKnightTourUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution doesn't exist!");
            return false;
        } else {
            printSolution(sol);
        }
        return true;
    }

    // Solution Function
    private static boolean SolveKnightTourUtil(int x, int y, int movi, int[][] sol, int[] xMove, int[] yMove) {
        int k, next_x, next_y;

        if (movi == N * N) {
            return true;
        }

        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];

            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movi;

                if (SolveKnightTourUtil(next_x, next_y, movi + 1, sol, xMove, yMove))
                    return true;
                else
                    sol[next_x][next_y] = -1;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        SolveKnightTour();
    }


}
