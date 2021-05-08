package Questions.AmericanExpress;

import java.util.HashMap;

public class DistinctBinaryTree {
    static class Tree {
        int x;
        Tree l, r;
    }
    static Tree newNode(int data) {
        Tree temp = new Tree();
        temp.x = data;
        temp.l = temp.r = null;
        return temp;
    }
    static int largestUinquePathUtil(Tree node, HashMap<Integer,
            Integer> m) {
        if (node == null)
            return m.size();
        if (m.containsKey(node.x))
            m.put(node.x, m.get(node.x) + 1);
        else
            m.put(node.x, 1);
        int max_path = Math.max(largestUinquePathUtil(node.l, m),
                largestUinquePathUtil(node.r, m));
        if (m.containsKey(node.x))
            m.put(node.x, m.get(node.x) - 1);
        if (m.get(node.x) == 0)
            m.remove(node.x);

        return max_path;
    }

    static int largestUinquePath(Tree node) {
        if (node == null)
            return 0;
        HashMap<Integer,
                Integer> hash = new HashMap<Integer,
                Integer>();
        return largestUinquePathUtil(node, hash);
    }
}
