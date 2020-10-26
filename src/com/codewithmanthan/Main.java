package com.codewithmanthan;

import java.util.*;


class Main {

    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        rotate(arr, 4, arr.length);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    static void rotate(int arr[], int d, int len) {
        for (int i = 0; i < d; i++) {
            int temp = arr[i];
            arr[i] = arr[len - d + i];
            arr[len - d + i] = temp;
        }
    }

}
