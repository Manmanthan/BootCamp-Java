package DivideAndConquer;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {50, 23, 9, 18, 61, 32};

        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int i = start, j = mid + 1, k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }

        while (j <= end) {
            temp[k] = arr[j];
            k++;
            j++;
        }

        for (int x = start; x <= end; x++) {
            arr[x] = temp[x - start];
        }
    }
}
