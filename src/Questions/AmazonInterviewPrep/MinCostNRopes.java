package Questions.AmazonInterviewPrep;

import java.util.PriorityQueue;

public class MinCostNRopes {

    static int minCost(int arr[]) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            q.add(arr[i]);
        }

        int minCost = 0;
        while (q.size() > 1) {
            int n1 = q.poll();
            int n2 = q.poll();
            minCost+=n1+n2;
            q.add(n1+n2);
        }
        return minCost;
    }

    public static void main(String[] args) {
        int len[] = {4, 3, 2, 6};
        System.out.println(minCost(len));
    }
}
