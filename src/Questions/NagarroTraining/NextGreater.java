package Questions.NagarroTraining;

import java.util.Stack;

public class NextGreater {
    private static int[] NGE(int[] arr, int n) {
        int[] arrIdx = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                arrIdx[st.pop()] = arr[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()){
            arrIdx[st.pop()] = -1;
        }
        return arrIdx;
    }

    public static void main(String[] args) {
        int[] arr = {11,13,21,3};

        int[] ans = NGE(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + ":" + ans[i]);
        }
    }
}
