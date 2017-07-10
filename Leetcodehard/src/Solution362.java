import java.util.ArrayDeque;
import java.util.ArrayList;

public class Solution362 {
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
		ArrayList<Integer> ans = new ArrayList<Integer>();
		if (nums == null || nums.length == 0 || nums.length < k) return ans;
		//make sure it's in a ascending or descending order
		ArrayDeque<Integer> deque= new ArrayDeque<Integer>();
		for (int i = 0; i < k - 1; i++) {
			addElement(deque, i, nums);
		}
		for (int i = k - 1; i < nums.length; i++) {
			addElement(deque, i, nums);
			ans.add(nums[deque.getLast()]);
			while (!deque.isEmpty() && deque.getFirst() <= i - k + 1) {
				deque.removeFirst();
			}
			while (!deque.isEmpty() && deque.getLast() <= i - k + 1) {
				deque.removeLast();
			}
		}
		return ans;
    }
	private void addElement(ArrayDeque<Integer> deque, int i , int[] nums) {
		if (deque.isEmpty() || nums[i] >= nums[deque.getLast()]) {
			deque.add(i);
		} else if (nums[i] <= nums[deque.getFirst()]) {
			deque.addFirst(i);
		} else {
			while (!deque.isEmpty() && nums[deque.getFirst()] < nums[i]) {
				deque.removeFirst();
			}
			deque.addFirst(i);
		}
	}
}
