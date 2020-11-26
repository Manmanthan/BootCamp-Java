package Questions.AmazonInterviewPrep;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningStreamMedian {
    public static void printMedian(int[] arr) {
        double med = arr[0];

        //Max heap
        PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
        //Min heap
        PriorityQueue<Integer> greater = new PriorityQueue<>();

        smaller.add(arr[0]);
        System.out.print(med + " ");

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];

            //Case1: Left side of heap has more elements
            if (smaller.size() > greater.size()) {
                if (x < med) {
                    greater.add(smaller.remove());
                    smaller.add(x);
                } else
                    greater.add(x);
                med = (double) (smaller.peek() + greater.peek()) / 2;
            }

            //Case2: Both heap have equal number of elements
            else if (smaller.size() == greater.size()) {
                if (x > med) {
                    greater.add(x);
                    med = (double) greater.peek();
                } else {
                    smaller.add(x);
                    med = (double) smaller.peek();
                }
            }

            //Case3: Right side of the heap has more elements
            else {
                if (x > med) {
                    smaller.add(greater.remove());
                    greater.add(x);
                } else
                    smaller.add(x);
                med = (double) (smaller.peek() + greater.peek()) / 2;
            }

            System.out.print(med + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 15, 10, 20, 3};
        printMedian(arr);
    }
}
