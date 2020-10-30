package Questions.DivideAndConquer;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }

        System.out.println(binarySearch(arr, 4));
    }

    static int binarySearch(int arr[], int x) {
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] > x) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}







