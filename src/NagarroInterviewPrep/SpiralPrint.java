package NagarroInterviewPrep;

import java.util.Scanner;

public class SpiralPrint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int M = scn.nextInt();
        int N = scn.nextInt();
        int[][] arr = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        spiralPrint(arr, M, N);
    }

    public static void spiralPrint(int[][] arr, int er, int ec) {
        int i, cr = 0, cc = 0;

        while (cr < er && cc < ec) {

            for (i = cc; i < ec; i++) {
                System.out.print(arr[cr][i] + " ");
            }
            cr++;

            for (i = cr; i < er; i++) {
                System.out.print(arr[i][ec - 1] + " ");
            }
            ec--;

            if (cr < er) {
                for (i = ec - 1; i >= cc; i--) {
                    System.out.print(arr[er - 1][i] + " ");
                }
                er--;
            }

            if (cc < ec) {
                for (i = er - 1; i >= cr; i--) {
                    System.out.print(arr[i][cc] + " ");
                }
                cc++;
            }
        }
    }
}
