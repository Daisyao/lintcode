import java.util.Stack;

public class Solution126 {
	public TreeNode maxTree(int[] A) {
        // write your code here
		if (A == null || A.length == 0) return null;
		Stack<TreeNode> stack= new Stack<TreeNode>();
		for (int i = 0; i <= A.length; i++) {
			int cur = (i==A.length ? Integer.MAX_VALUE : A[i]);
			if (stack.isEmpty() || cur < stack.peek().val) {
				stack.push(new TreeNode(cur));
			} else {   //bigger than stack pop
				TreeNode temp = stack.pop();
				if (stack.isEmpty() || cur < stack.peek().val) {
					TreeNode newRoot = new TreeNode(cur);
					newRoot.left = temp;
					stack.push(newRoot);
				} else {
					stack.peek().right = temp;
					i--;
				}
				
			}
		}
		return stack.peek().left;
    }
}
