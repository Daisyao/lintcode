import java.util.ArrayList;
import java.util.Arrays;

public class Solution018 {
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
		if (nums == null) return null;
		ArrayList<Integer> toAdd = new ArrayList<Integer>(0);
		Arrays.sort(nums);
		helper(toAdd, nums, 0);
		return result;
    }
	private void helper(ArrayList<Integer> toAdd, int[] nums, int pos) {
		result.add(new ArrayList<Integer>(toAdd));
		for(int i = pos; i < nums.length; i++) {
			if (i != pos && nums[i] == nums[i - 1] ) {
				continue;
			}
			toAdd.add(nums[i]);
			helper(toAdd, nums, i + 1);
			toAdd.remove(toAdd.size() - 1);
		}
	}
}