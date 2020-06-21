package DynamicProgramming;

public class CoinChange {
    public static void main(String[] args){
        printPattern(4);
    }
    public static void printPattern(int rows) {

        for(int i = 1; i <= rows; ++i) {
            for(int j = 1; j <= i; ++j) {
                System.out.print("1 ");
            }
            System.out.println();
        }
    }
}
