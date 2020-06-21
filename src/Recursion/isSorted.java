package Recursion;

import java.util.Scanner;

public class isSorted {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(isSorted(arr, 0));
    }

    public static boolean isSorted(int arr[], int si){
        if (si == arr.length-1){
            return true;
        }
        if (arr[si] > arr[si+1]){
            return false;
        }else {
            boolean ans = isSorted(arr, si+1);
            return ans;
        }
    }
}
