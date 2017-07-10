import java.util.HashMap;

public class TrieNode {
	HashMap <Character, TrieNode> children;
    boolean isWord;
    String s;
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        isWord = false;
    }
}
