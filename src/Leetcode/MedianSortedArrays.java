package Leetcode;

import java.util.Arrays;

public class MedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        int[] arr = new int[m + n];

        System.arraycopy(nums1, 0, arr, 0, m);
        System.arraycopy(nums2, 0, arr, m, n);

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Working: " + arr[i]);
        }
        return calMed(arr);
    }

    private static double calMed(int[] arr) {
        int n = arr.length;
        double ans;
        if (n % 2 == 0) {
            int z = n / 2;
            int n1 = arr[z];
            int n2 = arr[z - 1];
            ans = (double) (n1 + n2) / 2;
        } else {
            ans = arr[n / 2];
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = {1, 2}, nums2[] = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
