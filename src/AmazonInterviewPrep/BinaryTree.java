package AmazonInterviewPrep;

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree(int data){
        this.root = new Node(data);
    }

    BinaryTree(){
        this.root = null;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(5);
    }
}
