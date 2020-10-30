package Questions.DivideAndConquer;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapSort {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++){
            list.add(scn.nextInt());
        }

        heapSort(list);

        System.out.println(list);
    }

    private static void heapSort(ArrayList<Integer> list) {

        PriorityQueue<Integer> minheap = new PriorityQueue<>();

        for (int number : list){
            minheap.add(number);
        }

        int count = 0;

        while (!minheap.isEmpty()){
            int num = minheap.poll();
            list.set(count, num);
            count++;
        }
    }
}
