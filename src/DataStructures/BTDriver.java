package DataStructures;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class BTDriver {
    public static void main(String[] args) {
        // 50 true 25 true 12 false false true 39 false false true 75 true 41 false false true 87 false false
        BT tree = new BT();
        tree.display();
        System.out.println(tree.isBalanced());

        // QUESTIONS AHEAD ==>
//        int[] pre = {8 ,4 ,5 ,2 ,6 ,7 ,3 ,1};
//        int[] in = {4 ,8 ,2 ,5 ,1 ,6 ,3 ,7};
//        BT tree = new BT(pre, in);
//        tree.display();
//
//        System.out.println(tree.size2());
//
//        tree.preOrder();
//
//        tree.inOrder();
//
//        tree.postOrder();
//
//        System.out.println(tree.max());
//
//        System.out.println(tree.min());
//
//        tree.levelOrder();
//
//        tree.mirror();
//
//        tree.display();
//
//        System.out.println(tree.diameter());
//        System.out.println(tree.isBST());
    }
}
