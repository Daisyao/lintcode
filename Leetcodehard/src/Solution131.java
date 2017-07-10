import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Solution131 {
	private class Point implements Comparable<Point>{
		int pos;
		int height;
		int flag;  // 1 start, 0 end;
		public Point(int i, int h, int flag) {
			pos = i;
			height = h;
			this.flag = flag;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			if (pos != o.pos) return pos - o.pos;
			if (flag == 1 && o.flag == 1) return o.height - height ;
			if (flag == 0 && o.flag == 0) return height -o.height;
			return flag > 0 ? -1 : 1;
			
		}
	}
	public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		if (buildings == null || buildings.length == 0 || buildings[0].length < 3) return ans;
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < buildings.length; i++) {
        	list.add(new Point(buildings[i][0],buildings[i][2], 1));
        	list.add(new Point(buildings[i][1],buildings[i][2], 0));
        }
        Collections.sort(list);
        for (Point i : list) {
        System.out.println(String.format("pos is %d, flag is %d, height is %d", i.pos, i.flag, i.height));
        }
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        ArrayList<Integer> now = null;
        for (Point i: list) {
        	if(i.flag == 1) {
        		if (map.isEmpty()) {
        			now = new ArrayList<Integer>();
        			now.add(i.pos); //start
        		} else if (i.height > map.firstKey()) {
        			now.add(i.pos); //end
        			now.add(map.firstKey());
        			ans.add(now);
        			now = new ArrayList<Integer>();
        			now.add(i.pos); //start
        		}
        		if (map.containsKey(i.height)) map.put(i.height, map.get(i.height) + 1);
        		else map.put(i.height, 1);
        	} else {
        		if (map.get(i.height) > 1) map.put(i.height, map.get(i.height) - 1);
        		else map.remove(i.height);
        		if(map.isEmpty()) {
        			now.add(i.pos); //end
        			now.add(i.height);
        			ans.add(now);
        			now = null;
        		} else if (i.height > map.firstKey()){
        			//System.out.println(String.format("set first is %d, position is %d", map.first(), i.pos));
        			now.add(i.pos); //end
        			now.add(i.height);
        			ans.add(now);
        			now = new ArrayList<Integer>();
        			now.add(i.pos);
        		}
        	}
        }
        return ans;
    }
}
