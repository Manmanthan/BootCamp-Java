package Questions.AmazonInterviewPrep;

class KLargestElement {
    public static void main(String[] args) {
        int arr[] = { 1, 23, 12, 9, 30, 2, 50 };
        int[] res = bubbleSortApproach(arr, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    static int[] bubbleSortApproach(int[] arr, int k) {
        int[] res = new int[k];
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                if (j == n-i-2){
                    res[i] = arr[j+1];
                }
            }
        }
        return res;
    }
}
