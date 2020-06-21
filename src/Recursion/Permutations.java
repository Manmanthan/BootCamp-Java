package Recursion;

import java.util.Scanner;

public class Permutations {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        String res = "";
        printPermutations(str, res);

    }

    public static void printPermutations(String str, String res) {
        if (str.length() == 0){
            System.out.println(res);
            return;
        }

        for (int i = 0; i < str.length(); i++){
            char cc = str.charAt(i);
            String ros = str.substring(0, i)+ str.substring(i+1);
            printPermutations(ros, res + cc);
        }
    }
}
