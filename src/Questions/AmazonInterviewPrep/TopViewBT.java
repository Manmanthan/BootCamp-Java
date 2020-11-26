package Questions.AmazonInterviewPrep;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBT {
    static class Node {
        int key;
        Node left, right;

        Node(int data) {
            key = data;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;

        BinaryTree() {
            root = null;
        }

        static void TopView(Node root) {
            class QueueObj {
                Node node;
                int hd;

                QueueObj(Node node, int data) {
                    this.hd = data;
                    this.node = node;
                }
            }

            Queue<QueueObj> q = new LinkedList<QueueObj>();
            Map<Integer, Node> map = new TreeMap<Integer, Node>();

            if (root == null)
                return;
            else
                q.add(new QueueObj(root, 0));

            while (!q.isEmpty()) {
                QueueObj tempObj = q.poll();
                if (!map.containsKey(tempObj.hd))
                    map.put(tempObj.hd, tempObj.node);

                if (tempObj.node.left != null)
                    q.add(new QueueObj(tempObj.node.left, tempObj.hd - 1));

                if (tempObj.node.right != null)
                    q.add(new QueueObj(tempObj.node.right, tempObj.hd + 1));
            }
            for (Map.Entry<Integer, Node> e : map.entrySet()) {
                System.out.println(e.getValue().key);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        tree.TopView(tree.root);
    }
}
