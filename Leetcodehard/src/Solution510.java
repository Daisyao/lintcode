
public class Solution510 {
	public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		int max = 0;
		int[] histogram = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j]) {
					histogram[j] += 1;
				} else {
					histogram[j] = 0;
				}
			}
			max = Math.max(max, new Solution122().largestRectangleArea(histogram));
		}
        return max;
    }
//	private int findMax(int[] histogram) {
//		int max = 0;
//		return max;
//	}
}
