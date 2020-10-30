package Questions.Recursion;

import java.util.Scanner;

public class MazePathDiagonal {
    public static int count = 0;
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        String res = "";
        mazePath_D(0, 0, row, col, res);
        System.out.println();
        System.out.print(count);

    }
    public static void mazePath_D(int cr, int cc, int er, int ec, String res){
        if (cc == ec-1 && cr == er-1){
            System.out.print(res+ " ");
            count++;
            return;
        }
        if (cc >= ec || cr >= er){
            return;
        }

        mazePath_D(cr+1, cc, er, ec, res+"V");
        mazePath_D(cr, cc+1, er, ec, res+"H");
        mazePath_D(cr+1, cc+1, er, ec, res+"D");
    }
}
