
import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>(numRows);
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>(i+1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(j, listList.get(i-1).get(j-1) + listList.get(i-1).get(j));
                }
            }
            listList.add(i, list);
            
        }

//        List<Integer> list = new ArrayList<Integer>();
//        for (int i = 0; i < numRows; i++) {
//            list.add(0, 1);
//            for (int j = 1; j < list.size()-1; j++) {
//                list.set(j, list.get(j)+list.get(j+1));
//            }
//            listList.add(new ArrayList<Integer>(list));
//        }
        return listList;
    }
}
