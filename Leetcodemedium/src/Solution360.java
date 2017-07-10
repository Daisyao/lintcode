import java.util.ArrayList;
import java.util.TreeSet;

public class Solution360 {
	public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
		ArrayList<Integer> answer = new ArrayList<Integer>();
		if (nums == null || nums.length ==0 || k > nums.length) {
			return answer;
		}
		TreeSet<Element> smaller = new TreeSet<Element>();
		TreeSet<Element> bigger = new TreeSet<Element>();
		for (int i = 0; i < k - 1; i++) {
			addTree(new Element(i, nums[i]), smaller, bigger);
			System.out.println(smaller.last().val);
			System.out.println();
		}
		for (int i = k - 1; i < nums.length; i++) {
			addTree(new Element(i, nums[i]), smaller, bigger);
			System.out.println(smaller.last().val);
			answer.add(smaller.last().val);
			deleteTree(new Element(i - k + 1, nums[i - k + 1]), smaller, bigger);
			
		}
		return answer;
    }
	private void addTree(Element e, TreeSet<Element> smaller, TreeSet<Element> bigger) {
		if (smaller.size()> bigger.size()) {
			if (e.compareTo(smaller.last()) > 0) {
				bigger.add(e);
			} else {
				bigger.add(smaller.pollLast());
				smaller.add(e);
			}
		} 
		//add smaller
		else { 
			if (smaller.isEmpty() || e.compareTo(bigger.first()) < 0) {
				smaller.add(e);
			} else {
				smaller.add(bigger.pollFirst());
				bigger.add(e);
			}
		}
		
	}
	private void deleteTree(Element e, TreeSet<Element> smaller, TreeSet<Element> bigger) {
		if (smaller.contains(e)) {
			smaller.remove(e);
			if (smaller.size() < bigger.size()) {
				smaller.add(bigger.pollFirst());
			}
		} else {
			bigger.remove(e);
			if (smaller.size() > 1 + bigger.size()) {
				bigger.add(smaller.pollLast());
			}
		}
	}
	private class Element implements Comparable<Element>{
		int val;
		int id;
		public Element(int index, int x) {
			id = index;
			val = x;
		}
		@Override
		public int compareTo(Element o) {
			// TODO Auto-generated method stub
			return Integer.compare(val, o.val);
		}
	}
}
