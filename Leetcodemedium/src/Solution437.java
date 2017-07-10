
public class Solution437 {
	public int copyBooks(int[] pages, int k) {
	        // write your code here
		if (pages.length == 0 || pages.length < k) return 0;
		
		int sum = 0;
		for (int i = 0; i < pages.length; i++) {
			sum += pages[i];
		}
		int max = pages[0];
		int start = max;
		int end = sum;
		while (start  + 1< end) {
			int mid = start + (end - start) / 2;
			if (count(pages, mid) > k) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (count(pages, start) == k) return start;
		return end;
	}
	private int count(int[] pages, int max) {
		int sum = 0;
		int count = 1;
		for (int i = 0; i < pages.length; i++) {
			if (sum + pages[i] > max) {
				sum = 0;
				count++;
			}
			sum += pages[i];
		}
		return count;
	}
}
