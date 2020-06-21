package DivideAndConquer;

public class MergeSort {

    void mergeSort(int arr[], int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    void merge(int[] arr, int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int i = 0; i < n2; i++)
            R[i] = arr[m + i + 1];

        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                arr[k] = L[i];
                k++;
                i++;
            } else {
                arr[k] = R[j];
                k++;
                j++;
            }
        }

        while (i < n1) {
            arr[k] = L[i];
            k++;
            i++;
        }

        while (j < n2) {
            arr[k] = R[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
