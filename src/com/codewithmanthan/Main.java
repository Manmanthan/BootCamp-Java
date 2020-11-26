package com.codewithmanthan;

import java.util.*;

class Main {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class BinaryTree {
        Node root;

        BinaryTree() {
            this.root = null;
        }

        void levelOrder() {
            Queue<Node> q = new LinkedList<>();
            q.add(this.root);
            while (!q.isEmpty()) {
                Node nn = q.poll();
                System.out.println(nn.data);
                if (nn.left != null)
                    q.add(nn.left);
                if (nn.right!= null)
                    q.add(nn.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        tree.levelOrder();
    }
}
