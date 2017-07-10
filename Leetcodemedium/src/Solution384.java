
public class Solution384 {
	public int lengthOfLongestSubstring(String s) {
        // write your code here
		if (s == null) {
            return 0;
        }
        int[] map = new int[256];
        int length = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length()) {
                if (map[s.charAt(j)] == 0) {
                    map[s.charAt(j)] = 1;
                    j++;
                } else {
                    length = Math.max(length, j - i);
                    break;
                }
            }
            length = Math.max(length, j - i);
            map[s.charAt(i)]--;
        }
        return length;
    }
}
