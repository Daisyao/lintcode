
public class Solution28 {
    public int strStr(String haystack, String needle) {
        int length = needle.length();
        if (length == 0) return 0;
        for (int i= 0; i<haystack.length() -length +1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i+length).equals(needle))
                    return i;
            }
        }
        return -1;
    }
}
