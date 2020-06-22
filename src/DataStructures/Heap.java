package DataStructures;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        int count = 0;

        while (true) {
            int n = s.nextInt();

            if (n == -1) {
                printHeap(minHeap);
                break;
            }else if (count < k) {
                minHeap.add(n);
                count++;
            }else {
                if (minHeap.peek() < n) {
                    minHeap.poll();
                    minHeap.add(n);
                }
            }
        }
    }

    private static void printHeap(PriorityQueue<Integer> minHeap) {
        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
    }
}
