package Questions.NagarroTraining;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = {84, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(stockSpan(arr, arr.length)));
    }

    public static int[] stockSpan(int[] height, int n) {
        // Span Array
        int[] span = new int[n];
        // Span of first element is always 1
        span[0] = 1;

        Stack<Integer> st = new Stack<>();
        // Span for 0th element is already calculated
        st.push(0);

        for (int curr = 1; curr < n; curr++) {
            // Pop all the elements less than the curr element
            while (!st.isEmpty() && height[st.peek()] < height[curr]) {
                st.pop();
            }
            // Subtract index for the next greater element to cal the span
            span[curr] = st.isEmpty() ? curr + 1 : curr - st.peek();

            st.push(curr);
        }
        return span;
    }
}
