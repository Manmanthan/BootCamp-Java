package Questions.NagarroInterviewPrep;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class TopViewBT {
    Node root;

    public TopViewBT() {
        root = null;
    }

    private void topView(Node root) {
        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd){
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>();

        if (root == null){
            return;
        }else {
            q.add(new QueueObj(root, 0));
        }
    }
}
