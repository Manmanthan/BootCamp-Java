package Questions.AmazonInterviewPrep;

public class ViewsBT {
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;
        static int max_level = 0;

        // recursive function to print left view
        void leftViewUtil(Node node, int level) {
            if (node == null)
                return;
            if (max_level < level) {
                System.out.print(node.data + " ");
                max_level = level;
            }
            leftViewUtil(node.left, level + 1);
            leftViewUtil(node.right, level + 1);
        }

        void leftView() {
            leftViewUtil(root, 1);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(40);

        tree.leftView();
    }
}
