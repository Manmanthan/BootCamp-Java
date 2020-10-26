package Questions.Arrays;

public class ArrayRotation {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
//        rotate(arr, 3, arr.length);
        rotateFast(arr, 3, arr.length);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    // Time Complexity O(n)
    static void rotateFast(int arr[], int d, int n) {
        d = d % n;
        int i, j, k, temp;
        int gcd = calGCD(d, n);
        for (i = 0; i < gcd; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= n)
                    k = k - n;
                if (k == i)
                    break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }

    }

    // Time Complexity -> O(nd)
    static void rotate(int arr[], int d, int n) {
        d = d % n;
        for (int i = 0; i < d; i++) {
            int temp = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n - 1] = temp;
        }
    }

    static int calGCD(int a, int b) {
        if (b == 0) return a;
        else return calGCD(b, a % b);
    }
}
