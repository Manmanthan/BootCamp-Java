package Questions.AmazonInterviewPrep;

import java.util.LinkedList;

class MergeLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class MergeLists {
        Node head;

        /* Method to insert a node at  
           the end of the linked list */
        public void addToTheLast(Node node) {
            if (head == null) {
                head = node;
            } else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = node;
            }
        }

        /* Method to print linked list */
        void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    static Node sortedMerge(Node n1, Node n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        if (n1.data < n2.data) {
            n1.next = sortedMerge(n1.next, n2);
            return n1;
        } else {
            n2.next = sortedMerge(n1, n2.next);
            return n2;
        }
    }

    public static void main(String[] args) {
        MergeLists ll1 = new MergeLists();
        ll1.addToTheLast(new Node(5));
        ll1.addToTheLast(new Node(10));
        ll1.addToTheLast(new Node(15));

        MergeLists ll2 = new MergeLists();
        ll2.addToTheLast(new Node(2));
        ll2.addToTheLast(new Node(3));
        ll2.addToTheLast(new Node(20));

        Node nn = sortedMerge(ll1.head, ll2.head);
        while (nn != null) {
            System.out.print(nn.data + " ");
            nn = nn.next;
        }
    }
}
