import java.util.PriorityQueue;

class Element implements Comparable<Element> {
	int x;
	int y;
	int val;
	public Element(int x, int y, int val) {
		this.val = val;
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Element o) {
		// TODO Auto-generated method stub
		return Integer.compare(val, o.val);
	}
	
}
public class Solution401 {
	public int kthSmallest(int[][] matrix, int k) {
		if (k > matrix.length*matrix[0].length) {
			return -1;
		}
		
		int n = matrix[0].length;
		int m = matrix.length;
		int [] dx = new int[]{0,1};
		int [] dy = new int[]{1,0};
		int hash[][] = new int[m][n];
		PriorityQueue<Element> minHeap= new PriorityQueue<Element>(k);
		minHeap.add(new Element(0,0,matrix[0][0]));
		hash[0][0] = 1;
		while (k > 1) {
			Element temp = minHeap.poll();
			for (int i = 0; i < 2; i++) {
				int nextx = temp.x+dx[i];
				int nexty = temp.y+dy[i];
				if (nextx < m && nexty < n && hash[nextx][nexty] != 1) {
					minHeap.add(new Element(nextx, nexty, matrix[nextx][nexty]));
					hash[nextx][nexty] = 1;
				}
			}
			k--;
		}
		return minHeap.peek().val;
	}
}
