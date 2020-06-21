package DivideAndConquer;

public class BubbleSort {
    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6};

        bubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    private static void bubbleSort(int[] arr) {

        for (int counter = 0; counter < arr.length; counter++){
            for (int j = 0; j < arr.length-1-counter; j++){

                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
    }
}
