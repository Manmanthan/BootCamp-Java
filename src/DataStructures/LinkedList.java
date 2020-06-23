package DataStructures;

import Questions.SpiralPrint;

import java.util.HashSet;

class LinkedList {

    private class Node {
        int data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public void display() {
        Node temp = this.head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public void addLast(int item) {
        // Create a new Node
        Node nn = new Node();
        nn.data = item;
        nn.next = null;
        // Attach to the previous Node
        if (this.size >= 1) {
            this.tail.next = nn;
        }
        // Update Summary Object
        if (this.size == 0) {
            this.head = nn;
        }
        this.tail = nn;
        this.size++;
    }

    public void addFirst(int item) {
        // Create a new Node
        Node nn = new Node();
        nn.data = item;
        // Attach to the next Node
        if (this.size >= 1) {
            nn.next = this.head;
        }
        // Update Summary Object
        if (this.size == 0) {
            this.tail = nn;
        }
        this.head = nn;
        this.size++;
    }

    public int getFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List is Empty");
        }
        return this.head.data;
    }

    public int getLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List is Empty");
        }
        return this.tail.data;
    }

    public int getAt(int index) throws Exception {
        if (index < 0 || index >= this.size) {
            throw new Exception("Invalid Index");
        }
        if (this.size == 0) {
            throw new Exception("Linked List is Empty");
        }
        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    private Node getNodeAt(int index) throws Exception {
        if (index < 0 || index >= this.size) {
            throw new Exception("Invalid Index");
        }
        if (this.size == 0) {
            throw new Exception("Linked List is Empty");
        }
        Node temp = head;
        for (int i = 1; i <= index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void addAt(int index, int item) throws Exception {
        if (index < 0 || index > this.size) {
            throw new Exception("Invalid Index");
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == this.size) {
            addLast(item);
        } else {
            // Create a new Node
            Node nn = new Node();
            nn.data = item;
            // Attach to the previous Node
            Node nm1 = getNodeAt(index - 1);
            Node np1 = getNodeAt(index + 1);
            nm1.next = nn;
            nn.next = np1;
            // Update Summary Object
            this.size++;
        }
    }

    public int removeFirst() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List is Empty");
        }
        int rv = this.head.data;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            size--;
        } else {
            head = head.next;
            this.size--;
        }
        return rv;
    }

    public int removeLast() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List is Empty");
        }
        int rv = this.tail.data;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
        } else {
            Node sizem2 = getNodeAt(this.size - 2);
            tail = sizem2;
            tail.next = null;
            this.size--;
        }
        return rv;
    }

    public int removeAt(int index) throws Exception {
        if (index < 0 || index >= this.size) {
            throw new Exception("Invalid Index");
        }
        if (this.size == 0) {
            throw new Exception("Linked List is Empty");
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == this.size - 1) {
            return removeLast();
        } else {
            Node nm1 = getNodeAt(index - 1);
            Node n = getNodeAt(index);
            Node np1 = getNodeAt(index + 1);
            nm1.next = np1;
            this.size--;
            return n.data;
        }
    }

    public void reverseData() throws Exception {
        if (this.size == 0) {
            throw new Exception("Linked List is Empty");
        }
        int left = 0;
        int right = this.size - 1;
        while (left < right) {
            Node ln = getNodeAt(left);
            Node rn = getNodeAt(right);

            int temp = ln.data;
            ln.data = rn.data;
            rn.data = temp;

            left++;
            right--;
        }
    }

    public boolean removeloop(){
        HashSet<Node> set = new HashSet<Node>();
        Node prev = null;
        Node head = this.head;

        while (head != null){
            if (set.contains(head)){
                prev.next = null;
                return true;
            }else {
                set.add(head);
                prev = head;
                head = head.next;
            }
        }
        return false;
    }
}








