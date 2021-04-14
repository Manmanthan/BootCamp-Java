package Leetcode;

import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;
        while (true) {
            char cc = s.charAt(0);
            int currNum = map.get(cc);
            if (!s.substring(1).isEmpty() && currNum < map.get(s.charAt(1))) {
                ans -= currNum;
            } else
                ans += currNum;
            s = s.substring(1);
            if (s.isEmpty())
                break;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("XX"));
    }
}
