import java.util.Arrays;

public class Solution633 {
	public int findDuplicate(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
        	return -1;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start + 1< end) {
        	if (nums[start] == nums[end]) {
        		return nums[start];
        	}
        	int mid = start + (end - start) / 2;
        	if (nums[mid] <= mid) {
        		end = mid;
        	} else {
        		start = mid;
        	}
        }
        return 0;
    }
}
