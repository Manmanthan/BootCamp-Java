package Recursion;

import java.util.HashSet;
import java.util.Scanner;

public class Subsequence {
    public static int count = 0;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        String res = "";

        printSS(str, res);
        System.out.println();
        System.out.println(count);
    }

    public static void printSS(String str, String res) {
        if (str.length() == 0) {
            System.out.print(res+" ");
            count++;
            return;
        }

        char cc = str.charAt(0);
        String ros = str.substring(1);
        printSS(ros, res);
        printSS(ros, res + cc);

    }

}
