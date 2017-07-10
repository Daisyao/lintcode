
import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> theStack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    theStack.push(s.charAt(i));
                    break;
                case ')':
                    if (theStack.isEmpty() || theStack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if (theStack.isEmpty() || theStack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if (theStack.isEmpty() || theStack.pop() != '{')
                        return false;
                    break;
                default:
                    break;
            }          
        }
        if (theStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
