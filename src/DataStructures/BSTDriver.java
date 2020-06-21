package DataStructures;

public class BSTDriver {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.add(50);
        tree.add(25);
        tree.add(75);
        tree.add(12);
        tree.add(37);
        tree.add(62);
        tree.add(87);

        tree.display();

        System.out.println(tree.isBalanced());

        System.out.println(tree.isBST());

//        int[] arr = {5, 10, 15, 23, 34, 45, 55, 58};
//        BST tree = new BST(arr);
//        tree.display();

        BST.LinkedList list = tree.bstToll();

        list.display();

    }
}
