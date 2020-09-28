package NagarroInterviewPrep;

public class MinimumProductSubset {

    public static void main(String[] args) {
        int a[] = { -1, -1, -2, 4, 3 };
        int n = 5;

        System.out.println(minProductSubset(a, n));
    }

    public static int minProductSubset(int[] arr, int n) {
        if (n == 1)
            return arr[0];

        int negMax = Integer.MIN_VALUE;
        int posMin = Integer.MAX_VALUE;
        int countNeg = 0, countZero = 0, product = 1;

        for (int i = 0; i < n; i++) {
            // Count Zeros
            if (arr[i] == 0) {
                countZero++;
                continue;
            }
            // Count negative numbers and maintain negMax
            if (arr[i] < 0) {
                countNeg++;
                negMax = Math.max(negMax, arr[i]);
            }
            // Get the posMin
            if (arr[i] > 0 && arr[i] < posMin) {
                posMin = arr[i];
            }
            // Update the product
            product *= arr[i];
        }

        // Main Logic
        if (countZero > 0 && countNeg == 0) {
            return 0;
        }
        if (countNeg == 0) {
            return posMin;
        }
        if (countNeg % 2 == 0) {
            product = product / negMax;
        }

        return product;
    }

    /*
    arr = {-1, -1, -2, 4, 3}

    Find the minimum product

    Brute Force:-
        Time Complexity = O(n^2)
        Calculate all the possible products

    Optimized Solution:-
        Time Complexity = O(n)
        Space Complexity = O(1)

        arr = {-1, -1, -2, 4, 3}

        1. Even negative numbers and no zero.{Multiply all except largest negative}
        2. Odd negative numbers and no zero.{Multiply all}
        3. If there are no negative and no zero.{Minimum of the array}
        4. If there are no negative.{Zero}

     */
}
