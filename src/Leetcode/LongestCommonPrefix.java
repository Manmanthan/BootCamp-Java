package Leetcode;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int n = strs.length;

        for (int i = 0; i < n; i++) {
            prefix = prefixUtil(prefix, strs[i]);
        }
        return prefix;
    }

    private static String prefixUtil(String str1, String str2) {
        String res = "";
        int n1 = str1.length(), n2 = str2.length();

        for (int i = 0, j = 0; i < n1 && j < n2; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            res += str1.charAt(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String arr[] = {"geeks", "geeksforgeeks", "geek"};
        System.out.print(longestCommonPrefix(arr));
    }
}
