
public class Solution189 {
	public void rorate(int[] nums, int k) {
		if (nums == null || nums.length == 0) return;
		k = k % nums.length;
		int[] temp = new int[k];
		for (int i = 0; i < k; i++) {
			temp[i] = nums[nums.length-k+i];
		}
		for (int i = nums.length-1; i >= k; i--) {
			nums[i] = nums[i-k];
		}
		for (int i = 0; i < k; i++) {
			nums[i] = temp[i];
		}
	}
}
