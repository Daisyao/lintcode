
import java.util.HashMap;
import java.util.Map;

// also question167
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexmap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(indexmap.containsKey(target - nums[i])) {
                result[0] = indexmap.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                indexmap.put(nums[i], i);
            }
        }
        return result;
    }
}
