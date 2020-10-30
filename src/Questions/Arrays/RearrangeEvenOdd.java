package Questions.Arrays;

import java.util.Arrays;

public class RearrangeEvenOdd {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        rearrangeEvenOdd(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void rearrangeEvenOdd(int arr[], int n) {
        int temp[] = new int[n];
        for (int i = 0; i < n; i++){
            temp[i]=arr[i];
        }
        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));

        int evenPos = n / 2;
        int oddPos = n - evenPos;

        int j = oddPos - 1;
        for (int i = 0; i < n; i += 2) {
            arr[i] = temp[j];
            j--;
        }

        j = oddPos;
        for (int i = 1; i < n; i += 2) {
            arr[i] = temp[j];
            j++;
        }
    }
}
/*
arr[] = {1, 2, 3, 4, 5, 6, 7} -> n = 7 {floor(n/2) - > 4}

Rearrange -> 4 5 3 6 2 7 1

arr[i] >= arr[j] if i is even and
arr[i]<=arr[j] if i is odd and j < i
 */