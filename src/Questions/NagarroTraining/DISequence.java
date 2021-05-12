package Questions.NagarroTraining;

import java.util.Stack;

public class DISequence {
    public static void main(String[] args) {
        formMin("IIIDDD");
    }

    private static void formMin(String inp) {
        Stack<Integer> st = new Stack<>();

        // For input n characters the output has n+1 numbers
        for (int i = 0; i <= inp.length(); i++) {
            st.push(i+1);

            if (i == inp.length() || inp.charAt(i) == 'I') {
                while (!st.isEmpty()) {
                    System.out.print(st.pop());
                }
            }
        }
    }
}
