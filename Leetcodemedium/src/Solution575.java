import java.util.Stack;

public class Solution575 {
	public String expressionExpand(String s) {
        // Write your code here
		if (s == null || s.length() == 0) return s;
		Stack<Object> stack = new Stack<Object>();
		Stack<Object> stack2 = new Stack<Object>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				int n = s.charAt(i) - '0';
				while (s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') {
					i++;
					n = n*10 + s.charAt(i) -'0';
				}
				stack.push(n);
				
			} else if (s.charAt(i) != ']') {
				stack.push(s.charAt(i));
			} else {
				StringBuilder temp = new StringBuilder();
				while ((stack.peek() instanceof Character && ((char)stack.peek() != '[')) 
						|| stack.peek() instanceof StringBuilder) {
					stack2.push(stack.pop());
				}
				if (stack.peek() instanceof Character && ((char)stack.peek() == '[')) {
					//pop '['
					stack.pop(); {
						while (!stack2.isEmpty()) {
							temp.append(stack2.pop());
						}
					}
					
				}
				//pop number
				
				if (stack.peek() instanceof Integer) {
					//add temp
					StringBuilder newtemp = new StringBuilder();
					int m = (int)stack.pop();
					//System.out.println(m);
					for (int j = 0; j < m; j++) {
						newtemp.append(temp);
					}
					stack.push(newtemp);
				}
 			}
		}
		while(!stack.isEmpty()) {
			stack2.push(stack.pop());
		}
		while(!stack2.isEmpty()) {
			sb.append(stack2.pop());
		}
		return sb.toString();
    }
}
