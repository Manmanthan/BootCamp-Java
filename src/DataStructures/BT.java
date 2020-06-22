package DataStructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BT {
    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    int size;

    BT() {
        Scanner s = new Scanner(System.in);
        this.root = takeInput(s, null, false);
    }

    private Node takeInput(Scanner s, Node parent, boolean isleftorright) {
        if (parent == null) {
            System.out.println("Enter the data for the root node");
        } else {
            if (isleftorright) {
                System.out.println("Enter the data for the left child of " + parent.data);
            } else {
                System.out.println("Enter the data for the right child of " + parent.data);
            }
        }

        int data = s.nextInt();
        Node node = new Node(data, null, null);
        this.size++;

        boolean choice = false;
        System.out.println("Do you have left child for " + node.data);
        choice = s.nextBoolean();
        if (choice) {
            node.left = this.takeInput(s, node, true);
        }

        choice = false;
        System.out.println("Do you have right child for " + node.data);
        choice = s.nextBoolean();
        if (choice) {
            node.right = this.takeInput(s, node, false);
        }

        return node;
    }

    public void display() {
        this.display(this.root);
    }

    private void display(Node node) {
        if (node.left != null) {
            System.out.print(node.left.data + "=>");
        } else {
            System.out.print("END=>");
        }

        System.out.print(node.data);

        if (node.right != null) {
            System.out.print("=>" + node.right.data);
        } else {
            System.out.print("=>END");
        }

        System.out.println();

        if (node.left != null) {
            this.display(node.left);
        }
        if (node.right != null) {
            this.display(node.right);
        }
    }


    // QUESTIONS AHEAD ==>

    // QUE 1
    public int size2() {
        return this.size2(this.root);
    }

    private int size2(Node node) {
        if (node == null) {
            return 0;
        }

        int lsize = this.size2(node.left);
        int rsize = this.size2(node.right);

        return lsize + rsize + 1;
    }

    // QUE 2
    public void preOrder() {
        this.preOrder(this.root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // QUE 3
    public void inOrder() {
        this.inOrder(this.root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // QUE 4
    public void postOrder() {
        this.postOrder(this.root);
        System.out.println();
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    // QUE 5
    public int max() {
        return this.max(this.root);
    }

    private int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int lmax = this.max(node.left);
        int rmax = this.max(node.right);

        return Math.max(lmax, Math.max(rmax, node.data));
    }

    // QUE 6
    public int min() {
        return this.min(this.root);
    }

    private int min(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int lmin = this.min(node.left);
        int rmin = this.min(node.right);

        return Math.min(lmin, Math.min(rmin, node.data));
    }

    // QUE 7
    public int height() {
        return this.height(this.root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        int lheight = this.height(node.left);
        int rheight = this.height(node.right);

        return Math.max(lheight, rheight) + 1;
    }

    //QUE 9
    public void levelOrder() {
        Queue<Node> q = new LinkedList();
        q.add(this.root);

        while (!q.isEmpty()) {
            Node rv = q.remove();
            System.out.print(rv.data + " ");
            if (rv.left != null) {
                q.add(rv.left);
            }
            if (rv.right != null) {
                q.add(rv.right);
            }
        }
        System.out.println();
    }

    //QUE 10
    public void mirror() {
        this.mirror(this.root);
    }

    private void mirror(Node node) {
        if (node == null) {
            return;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        this.mirror(node.left);
        this.mirror(node.right);
    }

    // QUE 11
    public int diameter() {
        return this.diameter(this.root);
    }

    private int diameter(Node node) {
        if (node == null) {
            return 0;
        }
        int lheight = this.height(node.left);
        int rheight = this.height(node.right);

        int f1 = lheight + rheight + 2;
        int f2 = this.diameter(node.right);
        int f3 = this.diameter(node.left);

        return Math.max(f1, Math.max(f2, f3));
    }

    public boolean isBST() {
        return this.isBST(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.data > max || node.data < min) {
            return false;
        } else if (!isBST(node.left, min, node.data)) {
            return false;
        } else if (!isBST(node.right, node.data, max)) {
            return false;
        }
        return true;
    }

    public BT(int[] pre, int[] in){
        this.root = this.constructBTPostIn(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    private Node constructBT(int[] pre, int presi, int preei, int[] in, int insi, int inei){
        if (presi > preei || insi > inei)
            return null;

        Node node = new Node(pre[presi], null, null);
        this.size++;

        int si = -1;
        for (int i = insi; i <= inei; i++) {
            if (in[i] == node.data) {
                si = i;
                break;
            }
        }

        int lsi = si - insi;

        node.left = constructBT(pre, presi+1, preei, in, insi, si - 1);
        node.right = constructBT(pre, presi + lsi + 1, preei, in, si+1, inei);
        return node;
    }

    private Node constructBTPostIn(int[] po, int posi, int poei, int[] in, int insi, int inei) {
        if (posi > poei || insi > inei)
            return null;
        Node node = new Node(po[poei], null, null);
        this.size++;

        int si = -1;
        for (int i = 0; i <= inei; i++) {
            if (in[i] == node.data) {
                si = i;
                break;
            }
        }

        int lsi = si - insi;

        node.left = constructBTPostIn(po, posi, posi+lsi-1, in, insi, si - 1);
        node.right = constructBTPostIn(po, posi+lsi, poei-1, in, si+1, inei);

        return node;
    }

}
