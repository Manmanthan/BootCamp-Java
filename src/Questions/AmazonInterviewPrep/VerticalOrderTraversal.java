package Questions.AmazonInterviewPrep;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    static class Node {
        int key;
        Node left;
        Node right;

        Node(int data) {
            key = data;
            left = null;
            right = null;
        }
    }

    static void getVerticalOrder(Node node, int hd, TreeMap<Integer, ArrayList<Integer>> map) {
        if (node == null) return;

        ArrayList<Integer> get = map.get(hd);
        if (get == null) {
            get = new ArrayList<>();
            get.add(node.key);
        } else {
            get.add(node.key);
        }
        map.put(hd, get);

        getVerticalOrder(node.left, hd - 1, map);
        getVerticalOrder(node.right, hd + 1, map);
    }

    static void printVerticalOrder(Node root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(root, hd, map);

        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
            System.out.print(e.getValue());
        }
    }

    public static void main(String[] args) {

        // TO DO Auto-generated method stub
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
    }
}
