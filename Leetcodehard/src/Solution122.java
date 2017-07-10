import java.util.Stack;

public class Solution122 {
	public int largestRectangleArea(int[] height) {
        // write your code here
		/*
        if (height == null || height.length == 0) {
        	return 0;
        }
        Stack<Element> stack = new Stack<Element>();
        int max = 0;
        int i = 0;
        while(i < height.length) {
        	if (stack.isEmpty() || height[i] > stack.peek().val) {
        		stack.push(new Element(i, height[i]));
        		i++;
        	} else {
        		Element temp = stack.pop();
        		//has no boundary in left
        		if (stack.isEmpty()) {
        			max = Math.max(max, temp.val * i);
        		} else {
        			max = Math.max(max, temp.val * (i - stack.peek().i - 1));
        		}
        		
        	}
        }
        //has no boundary in right
        while(!stack.isEmpty()) {
        	Element temp = stack.pop();
        	//has no boundary in left
        	if (stack.isEmpty()) {
        		max = Math.max(max, temp.val * height.length);
        	} else {
        		max = Math.max(max, temp.val * (height.length - stack.peek().i - 1));
        	}
        }
        return max;
	}
    private class Element implements Comparable<Element> {
    	int i;
    	int val;
    	public Element(int i, int val) {
    		this.i = i;
    		this.val = val;
    	}
		@Override
		public int compareTo(Element o) {
			// TODO Auto-generated method stub
			return Integer.compare(val, o.val);
		}
    } */
		if (height == null || height.length == 0) {
        	return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
        	int cur = (i == height.length) ? -1 : height[i];
        	while(!stack.isEmpty() && cur < height[stack.peek()]) {
        		int temp = stack.pop();
        		//has no boundary in left
        		if (stack.isEmpty()) {
        			max = Math.max(max, height[temp] * i);
        		} else {
        			max = Math.max(max, height[temp] * (i - stack.peek() - 1));
        		}
        	}
        	stack.push(i);
        }
        return max;
	}
}
