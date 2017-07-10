import java.util.PriorityQueue;

public class Solution363 {
	
	public int trapRainWater(int[][] heights) {
        // write your code here
		PriorityQueue<Element> wall = new PriorityQueue<Element>();
		if (heights == null || heights.length == 0 || heights[0].length == 0)
			return 0;
		int n = heights.length;
		int m = heights[0].length;
		int[][] flag = new int[n][m];
		//init
		for (int i = 0; i < m; i++) {
			wall.add(new Element(heights[0][i], 0, i));
			wall.add(new Element(heights[n - 1][i], n - 1, i));
			flag[0][i] = 1;
			flag[n - 1][i] = 1;
		}
		for (int i = 1; i < n - 1; i++) {
			wall.add(new Element(heights[i][0], i, 0));
			flag[i][0] = 1;
			wall.add(new Element(heights[i][m -1], i, m - 1));
			flag[i][m - 1] = 1;
 		}
		//traverse
		int sum = 0;
		int[] dx = new int[]{0, 0, 1, -1};
		int[] dy = new int[]{1, -1, 0, 0};
		while (!wall.isEmpty()) {
			Element start = wall.peek();
			System.out.println(start.val);
			System.out.println(start.i);
			System.out.println(start.j);
			System.out.println();
			for (int i = 0; i < 4; i++) {
				int posi = start.i + dx[i];
				int posj = start.j + dy[i];
				if (posi >= 0 && posi < n && posj >= 0 && posj < m 
						&& flag[posi][posj] == 0) {
					if (heights[posi][posj] < start.val) {
						sum += start.val - heights[posi][posj];
						System.out.println(posi);
						System.out.println(posj);
						System.out.println();
					} else {
						wall.add(new Element(heights[posi][posj], posi, posj));
					}
					flag[posi][posj] = 1;
				}
			}
			wall.poll();
		}
		
		return sum;
		
    }
	
	private class Element implements Comparable<Element>{
		int i;
		int j;
		int val;
		public Element(int val, int i, int j) {
			this.val = val;
			this.i = i;
			this.j = j;
		}
		@Override
		public int compareTo(Element o) {
			// TODO Auto-generated method stub
			return Integer.compare(val, o.val);
		}
	}
}
