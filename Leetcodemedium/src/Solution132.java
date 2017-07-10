import java.util.ArrayList;


public class Solution132 {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
    	ArrayList<String> result = new ArrayList<String>();
        if (board== null || board.length == 0) 
            return result;
        int n = board.length;
        int m = board[0].length;
        
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() == 0) {
                root.isWord = true;
                root.s = "";
            }
            insert(words.get(i), root); //possible ""
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                search(board, i, j, root, result);
            }
        }
        return result;
    }
    private void search(char[][] board, int x, int y, 
    					TrieNode node, ArrayList<String> result) {
    	if (node.isWord) {
    		if (!result.contains(node.s))
    			result.add(node.s);
    	}
    	if (x < 0 || x >= board.length || y < 0 || y >=board[0].length) return;
    	char c = board[x][y];
    	if (!node.children.containsKey(c)) return;
    	board[x][y] = '*';
    	search(board, x, y - 1, node.children.get(c), result);
    	search(board, x, y + 1, node.children.get(c), result);
    	search(board, x + 1, y, node.children.get(c), result);
    	search(board, x - 1, y, node.children.get(c), result);
    	board[x][y] = c;
    }
    private void insert(String word, TrieNode root) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char x = word.charAt(i);
            if (!node.children.containsKey(x)) {
                node.children.put(x, new TrieNode());
            }
            node = node.children.get(x);
        }
        
        node.isWord = true;
        node.s = word;
    }
}


