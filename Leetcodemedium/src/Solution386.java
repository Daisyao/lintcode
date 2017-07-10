
public class Solution386 {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null) {
            return 0;
        }
        int length = 0;
        int j = 0;
        int count = 0;
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && count <= k) {
                if (map[s.charAt(j)] > 0) {
                	map[s.charAt(j)]++;
                    j++;
                }
                else {
                    map[s.charAt(j)]++;
                    count++;
                    j++;
                }
            }
            if (count > k) {
                length = Math.max(length, j - i -1);
            } else {
                length = Math.max(length, j - i);
            }
            if (map[s.charAt(i)] > 1) {
                map[s.charAt(i)]--;
            } else {
                map[s.charAt(i)]--;
                count--;
            }
        }
        return length;
	}
}
