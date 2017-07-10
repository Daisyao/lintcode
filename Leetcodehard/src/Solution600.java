
public class Solution600 {
	
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
    	if (image == null || x >= image.length || y >= image[0].length) {
    		return 0;
    	}
    	int len = image[0].length;
    	int wid = image.length;
    	int left = findLeft (0, y, image);
    	int right = findRight (y, len -1, image);
    	int upper = findUp (0, x, image, left, right);
    	int down = findDown (x, wid - 1, image, left, right);
    	return (right - left + 1) * (down - upper + 1);
    }
    private int findLeft (int start, int end, char[][] image) {
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (isEmptyColumn(mid, image)) {
    			start = mid + 1;
    		} else {
    			end = mid;
    		}
    	}
    	if (isEmptyColumn(start, image)) {
    		return end;
    	} 
    	return start;
    }
    private int findRight (int start, int end, char[][] image) {
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (isEmptyColumn(mid, image)) {
    			end = mid - 1;
    		} else {
    			start = mid;
    		}
    	}
    	if (isEmptyColumn(end, image)) {
    		return start;
    	}
    	return end;
    }
    private int findUp (int start, int end, char[][] image, int left, int right) {
    	while (start + 1< end) {
    		int mid = start + (end - start) / 2;
    		if (isEmptyRow(mid, image, left, right)) {
    			start = mid + 1;
    		} else {
    			end = mid;
    		}
    	}
    	if (isEmptyRow(start, image, left, right)) {
    		return end;
    	} 
    	return start;
    }
    private int findDown (int start, int end, char[][] image, int left, int right) {
    	while (start + 1 < end) {
    		int mid = start + (end - start) / 2;
    		if (isEmptyRow(mid, image, left, right)) {
    			end = mid - 1;
    		} else {
    			start = mid;
    		}
    	}
    	if (isEmptyRow(end, image, left, right)) {
    		return start;
    	} 
    	return end;
    }
    private boolean isEmptyColumn (int column, char[][] image) {
    	for (int i = 0; i < image.length; i++) {
    		if (image[i][column] == '1') {
    			return false;
    		} 
    	}
    	return true;
    }
    private boolean isEmptyRow (int row, char[][] image, int left, int right) {
    	for (int i = left; i < right + 1; i++) {
    		if (image[row][i] == '1') {
    			return false;
    		} 
    	}
    	return true;
    }
}
