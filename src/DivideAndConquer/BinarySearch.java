package DivideAndConquer;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }

        System.out.println(binarySearch(arr, 4));
    }

    public static int binarySearch(int[] arr, int item) {

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {

            int mid = (lo + hi) / 2;

            if (arr[mid] < item) {
                lo = mid + 1;
            } else if (arr[mid] > item) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int BinarySearchRecursive(int lo, int hi, int item, int[] arr) {

        if (hi >= lo) {

            int mid = (lo + hi) / 2;

            if (arr[mid] == item){
                return mid;
            }

            if (arr[mid] < item){
                return BinarySearchRecursive(mid+1, hi, item, arr);
            }

            return BinarySearchRecursive(lo, mid-1, item, arr);
        }

        return -1;
    }
}







