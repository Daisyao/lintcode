
public class Solution407 {
	public int minimumSize(int[] nums, int s) {
		int j = 0;
		int sum = 0;
		int miniSize = nums.length + 1;
		for (int i = 0; i < nums.length; i++) {
			while (j < nums.length) {
				if (sum < s) {
					sum = sum + nums[j];
					j++;
				}
				if (sum >= s) {
					miniSize = Math.min(j-i-1, miniSize);
					break;
				}
			}
			
			sum = sum - nums[i];
		}
		if (miniSize != nums.length+1) {
			return miniSize;
		}
		return -1;
	}
}
