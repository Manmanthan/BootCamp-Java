package Questions.DynamicProgramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1 = "AGGTABDJJGGFSAFASFFDKJ";
        String str2 = "GXTXAYBKDJFNSADASD";

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        int m = arr1.length;
        int n = arr2.length;

        long start = System.currentTimeMillis();
        System.out.println("Length of LCS is " + lcsDP(arr1, arr2, m, n));
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");

        start = System.currentTimeMillis();
        System.out.println("Length of LCS is " + lcs(arr1, arr2, m, n));
        end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");
    }

    static int lcs(char[] arr1, char[] arr2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (arr1[m - 1] == arr2[n - 1])
            return 1 + lcs(arr1, arr2, m - 1, n - 1);
        else
            return Math.max(lcs(arr1, arr2, m, n - 1), lcs(arr1, arr2, m - 1, n));
    }

    static int lcsDP(char[] arr1, char[] arr2, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (arr1[i - 1] == arr2[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

}

// Reference: https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/

/*
Example -> "abcdefg" -> "abc", "abg", "bdg", "aeg", "acefg" ...etc

BRUTE FORCE ->
* For every nth element there will be nC2 combinations possible.
* For n elements the total possible combinations would be (2**n-1) since we don't consider subsequence of length 0.
* Time Complexity -> (n 2**n) {n is the time to check that the suubsequence is equal for both the strings}.

So a DP aproach would be of Time Complexity- O(mn).
 */
