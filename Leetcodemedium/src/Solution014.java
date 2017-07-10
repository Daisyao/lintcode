
public class Solution014 {
	public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null) return -1;
        int start = 0;
        int end = nums.length -1;
        while (start < end) {
            int mid = start + (end - start) /2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                end = mid;
            }
            System.out.println(start);
            System.out.println(end);
            System.out.println("");
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
