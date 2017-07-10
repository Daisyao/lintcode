

public class Solution101 {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return helper(root.left, root.right);
	}
	private boolean helper(TreeNode leftone, TreeNode rightone) {
		if (leftone == null || rightone == null) {
			return leftone == rightone;
		} 
		if (leftone.val != rightone.val) {
			return false;
		}
		return helper(leftone.left, rightone.right) && helper(leftone.right, rightone.left);
	}
}
