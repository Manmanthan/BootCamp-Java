package Questions.NagarroTraining;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 5, 7, 8};
        int k = 3;
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);

            if (dq.getFirst() == i-k){
                dq.removeFirst();
            }
            if (i >= k-1) {
                res.add(nums[dq.getFirst()]);
            }
        }

        System.out.println(res);
    }
}
