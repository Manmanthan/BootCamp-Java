package Questions.Arrays;

public class BlockSwapAlgo {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        blockSwapAlgo(arr, 0, 2, 7);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    static void blockSwapAlgo(int arr[], int i, int d, int n) {
        if (d == 0 || d == n)
            return;
        if (n - d == d) {
            swap(arr, i, n - d + i, d);
            return;
        }
        if (d < n - d) {
            swap(arr, i, n - d + i, d);
            blockSwapAlgo(arr, i, d, n - d);
        } else {
            swap(arr, i, d, n - d);
            blockSwapAlgo(arr, n - d + i, 2 * d - n, d);
        }
    }

    static void swap(int arr[], int fi,
                     int si, int d) {
        int i, temp;
        for (i = 0; i < d; i++) {
            temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }
}
