package DivideAndConquer;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {50, 23, 9, 18, 61, 32};

        quickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int pi = partition(arr, lo, hi);

            quickSort(arr, lo, pi - 1);
            quickSort(arr, pi + 1, hi);
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo - 1;

        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Final Swap
        int temp = arr[i + 1];
        arr[i + 1] = arr[hi];
        arr[hi] = temp;

        return i + 1;
    }
}
