
public class Solution89 {
	public int kSum(int A[], int k, int target) {
        // write your code here
        int count = 0;
        if (A == null || A.length == 0) return count;
        
        //initial
        //前i个达到j需要几个k 
        boolean[][][] dp = new boolean[A.length+1][target+1][k+1];
        for (int i = 0; i < A.length + 1; i++) {
            dp[i][0][0] = true;
        }
        for (int i = 1; i < A.length + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                for (int t = 1; t <= k && t <= i; t++) {
                	if ((j - A[i-1]) >= 0 && dp[i-1][j - A[i-1]][t-1]) {
                        dp[i][j][t] = true;
                        if (j == target && t == k) count++;
                    }
                        
                    if (dp[i-1][j][t]) dp[i][j][t] = true;
                }
            }
        }
        return count;
    }
}
