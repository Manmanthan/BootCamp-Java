package Questions.AmazonInterviewPrep;

public class StackGetMiddle {
    // We use a linkedlist because deleting middle from array is not O(1)
    static class Node {
        Node prev, next;
        int data;

        Node(int data) {
            this.data = data;
        }
    }

    static class Stack {
        Node head, mid;
        int count;

        Stack() {
            this.count = 0;
            this.head = this.mid = null;
        }
    }

    int findMiddle(Stack s) {
        if (s.count == 0) return -1;
        return s.mid.data;
    }

    void push(Stack s,int data) {
        Node nn = new Node(data);
        nn.prev = null;
        nn.next = s.head;
        s.count++;
        if (s.count == 1)
            s.mid = nn;
        else {
            s.head.prev = nn;
            if (s.count % 2 != 0)
                s.mid = s.mid.prev;
        }
        s.head = nn;
    }

    int pop(Stack s) {
        if (s.count == 0) return -1;
        Node head = s.head;
        s.head = s.head.next;

        if (s.head != null)
            s.head.prev = null;

        s.count--;

        if (s.count % 2 == 0)
            s.mid = s.mid.next;

        return head.data;
    }

    public static void main(String args[])
    {
        StackGetMiddle ob = new StackGetMiddle();
        Stack ms = new Stack();
        ob.push(ms, 11);
        ob.push(ms, 22);
        ob.push(ms, 33);
        ob.push(ms, 44);
        ob.push(ms, 55);
        ob.push(ms, 66);
        ob.push(ms, 77);

        System.out.println("Item popped is " + ob.pop(ms));
        System.out.println("Item popped is " + ob.pop(ms));
        System.out.println("Middle Element is " + ob.findMiddle(ms));
    }

}
