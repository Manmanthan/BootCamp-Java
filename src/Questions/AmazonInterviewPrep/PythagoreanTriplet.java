package Questions.AmazonInterviewPrep;

import java.util.Arrays;

class PythagoreanTriplet {
    public static void main(String[] args) {
        int ar[] = {3, 1, 4, 6, 5};
        int ar_size = ar.length;
        if (isTriplet(ar, ar_size) == true)
            System.out.println("Yes");
        else
            System.out.println("No");

        if (isTriplet2(ar, ar_size) == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    // O(n**3)

    static boolean isTriplet(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int x = arr[i] * arr[i], y = arr[j] * arr[j], z = arr[k] * arr[k];
                    if (x == y + z || y == x + z || z == x + y)
                        return true;
                }
            }
        }
        return false;
    }

    // O(n***2)

    static boolean isTriplet2(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * arr[i];
        }

        Arrays.sort(arr);
        // By using meet in middle algorithm
        for (int i = n - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (arr[l] + arr[r] == arr[i]) {
                    return true;
                }
                if (arr[l] + arr[r] < arr[i])
                    l++;
                else
                    r--;
            }
        }
        return false;
    }
}
