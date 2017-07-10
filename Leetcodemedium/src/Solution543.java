import java.util.Arrays;
import java.util.PriorityQueue;

class Map implements Comparable<Map>{
	int x;
	int y;
	int val;
	public Map(int x, int y, int val) {
		this.x = x;
		this.y = y;
		this.val = val;
	}
	@Override
	public int compareTo(Map o) {
		// TODO Auto-generated method stub
		return o.val - val;
	}
}

//class myComparator implements Comparator<Map> {
//
//	@Override
//	public int compare(Map o1, Map o2) {
//		// TODO Auto-generated method stub
//		return o2.val - o1.val;
//	}
//
//}
public class Solution543 {
	public int KthInArrays(int[][] arrays, int k) {
        // Write your code here
		for (int i = 0; i < arrays.length; i++) {
			Arrays.sort(arrays[i]);;
		}
		PriorityQueue<Map> maxHeap = new PriorityQueue<Map>(k);
		for (int i = 0; i < arrays.length; i++) {
			if (arrays[i].length > 0) {
				maxHeap.add(new Map(i, arrays[i].length - 1, arrays[i][arrays[i].length - 1]));
			}
		}
		while (k > 1) {
			Map temp = maxHeap.poll();
			if (temp.y > 0) {
				maxHeap.add(new Map(temp.x, temp.y - 1, arrays[temp.x][temp.y - 1]));
			}
			k--;
		}
		return maxHeap.peek().val;
    }
}
