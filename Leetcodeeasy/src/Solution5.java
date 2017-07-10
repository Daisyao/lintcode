import java.util.Arrays;

public class Solution5 {
	public int kthLargestElement(int k, int[] nums) {
        // write your code here
		if (k > nums.length) return -1;
		Arrays.sort(nums);
		return nums[nums.length - k];
    }
}
