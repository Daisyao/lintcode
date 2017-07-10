
public class Solution585 {
	public int mountainSequence(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == 0 || mid == nums.length) {
                return nums[mid];
            }
            if (nums[mid] >nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return nums[mid];
            }
            if (nums[mid] > nums[mid - 1]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
	}
}
