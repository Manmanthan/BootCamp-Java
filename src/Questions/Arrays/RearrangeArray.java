package Questions.Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RearrangeArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(rearrangeArray(arr, arr.length)));
    }

    static int[] rearrangeArray(int arr[], int n) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (set.contains(i))
                arr[i] = i;
            else
                arr[i] = -1;
        }
        return arr;
    }
}
