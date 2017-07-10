import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution391 {
	public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
		if (airplanes == null || airplanes.isEmpty()) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < airplanes.size(); i++) {
        	int start = airplanes.get(i).start;
        	int end = airplanes.get(i).end;
        	if(!map.containsKey(start)) {
        		map.put(start, 1);
        		list.add(start);
        	} else {
        		map.put(start, map.get(start) + 1);
        	}
        	if (!map.containsKey(end)) {
        		map.put(end, -1);
        		list.add(end);
        	} else {
        		map.put(end, map.get(end) - 1);
        	}
        }
        Collections.sort(list);
        int max = 0;
        int record = 0;
        for (int i = 0; i < list.size(); i++) {
        	record += map.get(list.get(i));
        	if (record > max) max = record;
        }
        return max;
    }
	
	  
	 
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
