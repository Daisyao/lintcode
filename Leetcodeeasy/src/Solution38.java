
public class Solution38 {
    public String countAndSay(int n) {
        if (n < 1) {
            return "-1";
        }
        String s = "1";
        while (n > 1) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            char c = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    count++;
                }
                else {
                    temp.append(count);
                    temp.append(c);
                    c = s.charAt(i);
                    count = 1;
                }
            }
            temp.append(count);
            temp.append(c);
            s = temp.toString();
            n--;
        }
        return s;
    }
}
