import java.util.Collections;
import java.util.PriorityQueue;

public class Solution81 {
	public int[] medianII(int[] nums) {
        // write your code here
		if (nums == null) {
			return null;
		}
		int[] answer = new int[nums.length];
		if (nums.length == 0) {
			return answer;
		}
		PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(Collections.reverseOrder()); //a max heap
		PriorityQueue<Integer> bigger = new PriorityQueue<Integer>(); //a min heap
		
		for (int i = 0; i < nums.length; i++) {
			//add bigger
			if (smaller.size() > bigger.size()) {
				if (nums[i] > smaller.peek()) {
					bigger.add(nums[i]);
				} else {
					bigger.add(smaller.poll());
					smaller.add(nums[i]);
				}
			} 
			//add smaller
			else { 
				if (i == 0 || nums[i] < bigger.peek()) {
					smaller.add(nums[i]);
				} else {
					smaller.add(bigger.poll());
					bigger.add(nums[i]);
				}
			}
			answer[i] = smaller.peek();
		}
		return answer;
    }
}
