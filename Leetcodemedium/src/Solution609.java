import java.util.Arrays;

public class Solution609 {
	public int twoSum5(int[] nums, int target) {
        // Write your code here
		if (nums.length < 2) {
			return 0;
		}
		Arrays.sort(nums);
		int count = 0;
		int i = 0;
		int j = nums.length -1;
		while (i < j) {
			if (nums[i] + nums[j] > target) {
				j--;
			} else {
				count += j-i;
				i++;
			}
		}
		return count;
    }
}
