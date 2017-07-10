
public class Solution436 {
	public int maxSquare(int[][] matrix) {
        // write your code here
		if(matrix == null || matrix.length == 0 || matrix[0].length ==0) return 0;
		//initial
		int n = matrix.length;
		int m = matrix[0].length;
		int[][]maxS = new int[n][m];
		int max = 0;
		for (int i = 0; i < m; i++) {
			maxS[0][i] = matrix[0][i];
			max = Math.max(max, maxS[0][i]);
		}
		for (int i = 0; i < n; i++) {
			maxS[i][0] = matrix[i][0];
			max = Math.max(max, maxS[i][0]);
		}
		for (int i = 1; i< n; i++) {
			for (int j = 1; j < m; j++) {
				if(matrix[i][j] == 0) {
					maxS[i][j] = 0;
				} else {
					maxS[i][j] =Math.min(maxS[i-1][j-1], maxS[i-1][j]);
					maxS[i][j] =Math.min(maxS[i][j], maxS[i][j-1]);
				}
				
				max = Math.max(max, maxS[i][j]);
			}
		}
		return max;
    }
}
