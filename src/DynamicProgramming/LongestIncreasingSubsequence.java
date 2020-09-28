package DynamicProgramming;

public class LongestIncreasingSubsequence {

    static int max_ref;

    public static void main(String[] args) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 34, 34, 343, 43, 43, 43, 4, 34, 3, 43, 4, 3434, 343, 45, 4545, 4545, 4465, 7678, 787, 8, 54634};
        //{10, 22, 9, 33, 21, 50, 41, 60, 34,34,343,43,43,43,4,34,3,43,4,3434,343,45,4545,4545,4465,7678,787,8,54634,532,4,315,426,5,65,7433,5,425,325,46,57,5,74,53,534,7,68,78,758,466,24,534,654,865957,846,6,345,42,645,856,67,35,643,76,458,468,56,42,56246};
        int n = arr.length;
        max_ref = 1;

        // Time Analyzer
        long start = System.currentTimeMillis();

        lis(arr, n);
        System.out.println(max_ref);

        // Time Analyzer
        long end = System.currentTimeMillis();
        float sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");

        // Time Analyzer
        start = System.currentTimeMillis();

        System.out.println(lisDP(arr, n));

        // Time Analyzer
        end = System.currentTimeMillis();
        sec = (end - start) / 1000F;
        System.out.println(sec + " seconds");
    }

    static int lis(int[] arr, int n) {
        if (n == 1)
            return 1;
        int res, max_till_now = 1;

        for (int i = 1; i < n; i++) {
            res = lis(arr, i);
            if (arr[i - 1] < arr[n - 1] && res + 1 > max_till_now)
                max_till_now = res + 1;
        }

        if (max_ref < max_till_now)
            max_ref = max_till_now;

        return max_till_now;
    }

    static int lisDP(int[] arr, int n) {
        int lis[] = new int[n];
        int i, j, max = 0;

        for (i = 0; i < n; i++)
            lis[i] = 1;

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++)
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;

        }

        for (i = 0; i < n; i++)
            if (max < lis[i])
                max = lis[i];

        return max;
    }

}

// Reference: https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/

/*
arr[] = {50, 3, 10, 7, 40, 80}

-> Length of LIS = 4

This problem satisfies optimal substructure property and can be broken down to subproblems.

Input  : arr[] = {3, 10, 2, 11}
f(i): Denotes LIS of subarray ending at index ‘i’


      f(4)  {f(4) = 1 + max(f(1), f(2), f(3))}
  /    |    \
f(1)  f(2)  f(3) {f(3) = 1, f(2) and f(1) are > f(3)}
       |      |  \
      f(1)  f(2)  f(1) {f(2) = 1 + max(f(1)}
              |
            f(1) {f(1) = 1}

The time complexity for this recursive approach would be exponential.

DP Approach:

        Input  : arr[] = {3, 10, 2, 11}
        LIS[] = {1, 1, 1, 1} (initially)

arr[2] > arr[1] {LIS[2] = max(LIS [2], LIS[1]+1)=2} -> LIS[] = {1, 2, 1, 1}
arr[3] < arr[1] {No change} -> LIS[] = {1, 2, 1, 1}
arr[3] < arr[2] {No change} -> LIS[] = {1, 2, 1, 1}
arr[4] > arr[1] {LIS[4] = max(LIS [4], LIS[1]+1)=2} -> LIS[] = {1, 2, 1, 2}
arr[4] > arr[2] {LIS[4] = max(LIS [4], LIS[2]+1)=3} -> LIS[] = {1, 2, 1, 3}
arr[4] > arr[3] {LIS[4] = max(LIS [4], LIS[3]+1)=2} -> LIS[] = {1, 2, 1, 3}
 */