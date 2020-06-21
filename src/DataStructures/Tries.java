package DataStructures;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Tries {
    public class Node {
        char data;
        HashMap<Character, Node> children;
        boolean isTerminal;

        Node(char data, boolean isTerminal) {
            this.data = data;
            this.children = new HashMap<>();
            this.isTerminal = isTerminal;
        }
    }

    private Node root;
    private int numWords;

    Tries() {
        this.root = new Node('\0', false);
        this.numWords = numWords;
    }

    public void addWord(String word) {
        this.addWord(this.root, word);
    }

    private void addWord(Node node, String word) {
        if (word.length() == 0) {
            if (node.isTerminal) {

            } else {
                node.isTerminal = true;
                this.numWords++;
            }

            return;
        }

        char cc = word.charAt(0);
        String ros = word.substring(1);

        Node child = node.children.get(cc);

        if (child == null) {
            child = new Node(cc, false);
            node.children.put(cc, child);
        }

        this.addWord(child, ros);
    }

    public void display() {
        this.display(this.root, "");
    }

    private void display(Node node, String res) {
        if (node.isTerminal) {
            System.out.println(res);
        }

        Set<Map.Entry<Character, Node>> childs = node.children.entrySet();
        for (Map.Entry<Character, Node> child : childs) {
            this.display(child.getValue(), res + child.getKey());
        }
    }

    public boolean searchWord(String word) {
        return this.searchWord(this.root, "");
    }

    private boolean searchWord(Node node, String word) {
        if (word.length() == 0) {
            if (node.isTerminal) {
                return true;
            } else {
                return false;
            }
        }

        char cc = word.charAt(0);
        String ros = word.substring(1);

        Node child = node.children.get(cc);

        if (child == null) {
            return false;
        }

        return this.searchWord(child, ros);
    }

    public void removeWord(String word) {
        this.removeWord(this.root, word);
    }

    private void removeWord(Node node, String word) {
        if (word.length() == 0) {
            if (node.isTerminal) {
                node.isTerminal = false;
                this.numWords--;
                return;
            } else {
                return;
            }
        }

        char cc = word.charAt(0);
        String ros = word.substring(1);

        Node child = node.children.get(cc);

        if (child == null) {
            return;
        }

        this.removeWord(child, ros);
        if (child.isTerminal == false && child.children.size() == 0){
            node.children.remove(child);
        }
    }
}
