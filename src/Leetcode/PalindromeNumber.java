package Leetcode;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int n = s.length();
        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(122));
    }
}
