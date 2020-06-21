package Recursion;

public class printBoardPath {
    public static void printBoard(int curr, int end, String ans) {
        if (curr > end){
            return;
        }
        if (curr == end) {
            System.out.println(ans);
            return;
        }
        for (int dice = 1; dice <= 6; dice++){
            printBoard(curr+dice, end, ans+dice);
        }
    }

    public static void main(String[] args){
        printBoard(0, 10, "");
    }
}
