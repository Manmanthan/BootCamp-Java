package Questions.Recursion;

import java.util.Scanner;
import java.util.Stack;

public class isBalanced_Stack {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(isBalanced(str));

    }
    public static boolean isBalanced(String str) throws Exception {
        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char cc = str.charAt(i);
            if (cc == '[' || cc == '(' || cc == '{') {
                stack.push(cc);
            } else if (cc == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char tc = (char) stack.peek();
                    if (tc == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            } else if (cc == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char tc = (char) stack.peek();
                    if (tc == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            } else if (cc == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char tc = (char) stack.peek();
                    if (tc == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            } else {

            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}