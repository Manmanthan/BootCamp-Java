package DivideAndConquer;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {50, 23, 9, 18, 61, 32};

        mergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void mergeSort(int arr[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            //Sort first and second halves
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            //Visualizing this one given array as two separate sorted arrays
            merge(arr, start, mid, end);
        }
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;

        // Create temp arrays.(Visualized Earlier)
        int F[] = new int[n1];
        int S[] = new int[n2];
        for (int i = 0; i < n1; i++)
            F[i] = arr[start + i];
        for (int i = 0; i < n2; i++)
            S[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = start;
        while (i < n1 && j < n2) {
            if (F[i] < S[j]) {
                arr[k] = F[i];
                i++;
            } else {
                arr[k] = S[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = F[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = S[j];
            k++;
            j++;
        }
    }
}
