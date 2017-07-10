
public class Solution53 {
    public int maxSubArray(int[] nums) {
    	if (nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        int max = sum; 
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
            	sum = sum + nums[i];
            } else {
            	sum = nums[i];
            }
        	max = Math.max(sum, max);
        }
        return max;
    }
}
