package Questions.AmazonInterviewPrep;

import java.util.Stack;

public class SpiralLevelOrder {
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

        void printSpiral() {
            int height = height(this.root);
            boolean itr = false;
            for (int i = 1; i <= height; i++) {
                printGivenLevel(this.root, i, itr);
                itr = !itr;
            }
        }

        void printGivenLevel(Node node, int level, boolean itr) {
            if (node == null) return;
            if (level == 1) System.out.print(node.data + " ");
            else if (level > 1) {
                if (itr == true) {
                    printGivenLevel(node.left, level - 1, itr);
                    printGivenLevel(node.right, level - 1, itr);
                } else {
                    printGivenLevel(node.right, level - 1, itr);
                    printGivenLevel(node.left, level - 1, itr);
                }
            }
        }

        int height(Node node) {
            if (node == null) {
                return 0;
            }
            int lHeight = this.height(node.left);
            int rHeight = this.height(node.right);

            return Math.max(lHeight, rHeight) + 1;
        }

        void printSpiralOptimized() {
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(this.root);
            while (!s1.isEmpty() || !s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    Node nn = s1.pop();
                    System.out.print(nn.data);
                    if (nn.right != null)
                        s2.push(nn.right);
                    if (nn.left != null)
                        s2.push(nn.left);
                }
                while (!s2.isEmpty()) {
                    Node nn = s2.pop();
                    System.out.print(nn.data);
                    if (nn.left != null)
                        s1.push(nn.left);
                    if (nn.right != null)
                        s1.push(nn.right);
                }
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
        System.out.println("Spiral order traversal of Binary Tree is ");
        tree.printSpiral();
        System.out.println("This is spiral print optimized:");
        tree.printSpiralOptimized();
    }
}
