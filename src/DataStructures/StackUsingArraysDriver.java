package DataStructures;

public class StackUsingArraysDriver {
    public static void main(String[] args) throws Exception {
        StackUsingArrays stack = new StackUsingArrays(5);

        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        stack.display();
    }
}
