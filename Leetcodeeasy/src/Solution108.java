
public class Solution108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) return null;
		int low = 0; int upper = nums.length-1;
		int mid = low + (upper - low)/2;
		TreeNode root = new TreeNode(nums[mid]);
		helper(root, low, mid-1, nums);
		helper(root, mid+1, upper, nums);
		return root;
		
	}
	private void helper(TreeNode root, int low, int upper, int[] nums) {
		if (low > upper) return;
		int mid = low + (upper - low)/2;
		if (nums[mid] < root.val) {
			root.left = new TreeNode(nums[mid]);
			helper(root.left, low, mid -1, nums);
			helper(root.left, mid+1, upper, nums);
		}
		else {
			root.right = new TreeNode(nums[mid]);
			helper(root.right, low, mid -1, nums);
			helper(root.right, mid+1, upper, nums);
		}
		
	}
	/**
	 * definition for a binary tree node.
	 */
	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
