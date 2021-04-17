package Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet;
        int n = s.length(), count = 0;

        for (int i = 0; i < n; i++) {
            charSet = new HashSet<>();
            int iterCount = 0;
            for (int j = i; j < n; j++) {
                // If repeated char found then break and update i.
                if (charSet.contains(s.charAt(j))){
                    break;
                }
                charSet.add(s.charAt(j));
                iterCount++;
            }
            if (iterCount > count)
                count = iterCount;
        }
        return count;
    }

    public static int longestSubstringOn(String s) {
        int n = s.length(), res = 0;
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex,-1);

        int i = 0;

        for (int j = 0; j < n; j++) {
            i = Math.max(i, lastIndex[s.charAt(j) + 1]);
            lastIndex[s.charAt(j)] = j;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
