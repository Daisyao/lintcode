import java.util.PriorityQueue;

class Sum implements Comparable<Sum>{
	int x;
	int y; 
	int val;
	public Sum (int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
	@Override
	public int compareTo(Sum o) {
		// TODO Auto-generated method stub
		return Integer.compare(val, o.val);
	}
}
public class Solution465 {
	public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
		int m = A.length;
		int n = B.length;
		int[] dx = new int[]{0,1};
		int[] dy = new int[]{1,0};
		boolean[][] hash = new boolean[m][n];
		PriorityQueue<Sum> minHeap = new PriorityQueue<Sum>(k);
		minHeap.add(new Sum(0, 0, A[0]+B[0]));
		hash[0][0] = true;
		while (k > 1) {
			Sum temp = minHeap.poll();
			for (int i = 0; i < 2; i++) {
				int nextx = temp.x + dx[i];
				int nexty = temp.y + dy[i];
				Sum nextSum = new Sum(nextx, nexty, 0);
				if (nextx < m && nexty < n && !hash[nextx][nexty]) {
					nextSum.val = A[nextx] + B[nexty];
					minHeap.add(nextSum);
					hash[nextx][nexty] = true;
				}
			}
			k--;
		}
		return minHeap.peek().val;
    }
}
