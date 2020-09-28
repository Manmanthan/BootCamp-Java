package DynamicProgramming;

public class EditString {

    public static void main(String[] args) {
        String str1 = "sundayadnsfdf";
        String str2 = "saturdaysfdmfdfdfd";

        // Time Analyzer
        long start = System.currentTimeMillis();

        System.out.println(editDist(str1, str2, str1.length(), str2.length()));

        // Time Analyzer
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");

        // Time Analyzer
        start = System.currentTimeMillis();

        System.out.println(editDistDP(str1, str2, str1.length(), str2.length()));

        // Time Analyzer
        end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");
    }

    static int editDist(String str1, String str2, int m, int n) {
        if (m == 0)
            return n;
        if (n == 0)
            return m;

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return editDist(str1, str2, m - 1, n - 1);
        }

        // Worst Case
        return 1 + Math.min(editDist(str1, str2, m, n - 1), Math.min(editDist(str1, str2, m - 1, n), editDist(str1, str2, m - 1, n - 1)));
    }

    static int editDistDP(String str1, String str2, int m, int n) {
        int dp[][] = new int[m+1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
            }
        }
        return dp[m][n];
    }

}

// Reference: https://www.geeksforgeeks.org/edit-distance-dp-5/

/*
m: Length of str1 (first string)
n: Length of str2 (second string)

1. If last characters of two strings are same, nothing much to do.
   Ignore last characters and get count for remaining strings. So we recur for lengths m-1 and n-1.
2. Else (If last characters are not same), we consider all operations on ‘str1’, consider all three
   operations on last character of first string, recursively compute minimum cost for all three operations
   and take minimum of three values.
Insert: Recur for m and n-1
Remove: Recur for m-1 and n
Replace: Recur for m-1 and n-1
 */
