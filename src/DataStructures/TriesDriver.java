package DataStructures;

public class TriesDriver {
    public static void main(String[] args){
        Tries trie = new Tries();

        trie.addWord("art");
        trie.addWord("arts");
        trie.addWord("bug");
        trie.addWord("boy");
        trie.addWord("see");
        trie.addWord("sea");
        trie.addWord("seen");

        trie.display();

        trie.removeWord("seen");

        trie.display();

    }
}
