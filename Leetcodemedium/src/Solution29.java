
public class Solution29 {
	public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s3.length() != (s1.length() + s2.length())) return false;
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < s3.length()) {
            if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
                k++;
                i++;
                continue;
            }
            if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
                k++;
                j++;
                continue;
            }
            System.out.println(s1.length());
            System.out.println(s2.length());
            System.out.println(s3.length());
            System.out.println(i);
            System.out.println(j);
            System.out.println(k);
            return false;
        }
        return true;
    }
}
