import java.util.ArrayList;

public class Solution91 {
	public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() == 0) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > max) max = A.get(i);
            if (A.get(i) < min) min = A.get(i);
        }
        //initial
        int len = max - min + 1;
        int[][] dp = new int[A.size()][len];
        
        for (int i = 0; i < len; i++) {
            dp[0][i] = Math.abs(A.get(0) - (i + min));
        }
        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k <= target; k++) {
                    if (j - k >= 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k] + Math.abs(A.get(i)-(j+min)));
                    }
                    if (j + k < len) {
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j+k] + Math.abs(A.get(i)-(j+min)));
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {

        	for (int j = 0; j < len; j++)
        	System.out.print(dp[i][j] + " ");
        	System.out.println();
        }
        for (int i = 0; i < len; i++) {
            result = Math.min(result, dp[A.size()-1][i]);
        }
        return result;
    }
}
