import java.util.ArrayList;
import java.util.List;

public class Solution623 {
	
    TriNode root;
    public List<String> kDistance(String[] words, String target, int x) {
        // Write your code here
        //initial
    	List<String> list = new ArrayList<String>();
        root = new TriNode(target.length()+1);
        buildTri(words, target.length());
        for (int i = 0; i < target.length()+1; i++) {
            root.dp[i] = i;
        }
        //build tri is fine  
        //initial dp
        searchHelper(root, target, x, "", list);
        return list;
        
    }
    private void searchHelper(TriNode cur, String target, int x, String s, List<String> list) {
        if (cur.isWord && cur.dp[target.length()] <= x) {
            list.add(s);
        }
        for (int i = 0; i < 26; i++) {
            if(cur.children[i] != null) {
                for (int k = 1; k < target.length()+1; k++) {
                    if (i == target.charAt(k-1) - 'a') {
                        cur.children[i].dp[k] =Math.min(cur.dp[k]+1, cur.children[i].dp[k-1] +1);
                        cur.children[i].dp[k] = Math.min(cur.children[i].dp[k], cur.dp[k-1]);
                    } else {
                        cur.children[i].dp[k] =Math.min(cur.dp[k]+1, cur.children[i].dp[k-1] +1);
                        cur.children[i].dp[k] = Math.min(cur.children[i].dp[k], cur.dp[k-1]+1);
                    }
                }
                searchHelper(cur.children[i], target, x, new String(s)+ String.valueOf((char)(i+'a')), list);
            }
        }
        return;
    }
    private void buildTri (String[] words, int length) {
        for (int i = 0; i < words.length; i++) {
            int len = words[i].length();
            if (len == 0) {
                root.isWord = true;
                continue;
            }
            TriNode tmp = root;
            for (int j = 0; j < len; j++) {
                int pos = words[i].charAt(j)-'a';
                if (tmp.children[pos] == null) {
                    tmp.children[pos] = new TriNode(length+1);
                    tmp.children[pos].dp[0] = j + 1; 
                }
                tmp = tmp.children[pos];
                if (j == len - 1) tmp.isWord = true;
            }
        }
    }
    private class TriNode {
        TriNode[] children;
        int dp[];
        boolean isWord;
        public TriNode (int len) {
            children = new TriNode[26];
            isWord = false;
            dp = new int[len];
        }
    }
}
