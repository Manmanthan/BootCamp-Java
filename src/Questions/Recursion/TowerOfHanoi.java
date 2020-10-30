package Questions.Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
    static void towersOfHanoi(int n, char source, char dest) {

            if (n == 0){
                return;
            }

        char temp = (char)('A' + 'B' + 'C' - source - dest);

        towersOfHanoi(n-1, source, temp);

        System.out.println("Moving ring " + n + " from " + source + " to " + dest);

        towersOfHanoi(n-1, temp, dest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        towersOfHanoi(n, 'A', 'B');
    }
}
