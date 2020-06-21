package Recursion;

import java.util.Scanner;

public class keypad {
    public static String table[] = { " ", ".+@$", "abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv", "wxyz" };
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String ques = scn.next();
        String ans = "";
        keypad1(ques, ans);
    }

    public static void keypad1(String ques, String ans) {

        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }


        char ch = ques.charAt(0);
        String ros = ques.substring(1);
        String code = table[ch - '0'];

        for (int i = 0; i < code.length(); i++)
            keypad1(ros, ans + code.charAt(i));

    }
}
