package Questions.NagarroInterviewPrep;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElementHeap {

    public static void main(String[] args) {

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        Scanner scn = new Scanner(System.in);

        int count = 0;
        int k = scn.nextInt();

        while (true) {
            int n = scn.nextInt();

            if (n == -1) {
                printKElements(minheap);
            }else if (count < k){
                minheap.add(n);
                count++;
            }else if (minheap.peek() < n){
                minheap.poll();
                minheap.add(n);
            }
        }
    }

    public static void printKElements(PriorityQueue<Integer> minheap) {
        while (!minheap.isEmpty()){
            System.out.println(minheap.poll());
        }
        System.exit(0);
    }
}
