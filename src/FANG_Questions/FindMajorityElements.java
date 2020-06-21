package FANG_Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FindMajorityElements {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        ArrayList<Integer> list = majorityElements(arr);

        if (list.isEmpty()){
            System.out.println("No Majority Elements");
        }else {
            Collections.sort(list);
            for (int num : list){
                System.out.print(num+ " ");
            }
        }
    }

    public static ArrayList<Integer> majorityElements(int[] arr) {

        int element1 = arr[1];
        int count1 = 0;
        int element2 = 0;
        int count2 = 0;

        for (int i = 0; i < arr.length; i++) {

            if (element1 == arr[i]) {
                count1++;
            } else if (element2 == arr[i]) {
                count2++;
            } else if (count1 == 0) {
                element1 = arr[i];
                count1 = 1;
            } else if (count2 == 0) {
                element2 = arr[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        //Iterate and find that element1 and element2 ka count n/3 se zaada hai ki nhi

        count1 = count2 = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == element1){
                count1++;
            }else if (arr[i] == element2){
                count2++;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (count1 > arr.length/3){
            list.add(element1);
        }
        if (count2 > arr.length/3){
            list.add(element2);
        }

        return list;
    }
}
