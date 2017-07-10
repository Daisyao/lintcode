
public class Solution593 {
	int[][]dp;
    int[]sum;
    int[][]flag;
    public int stoneGame2(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) return 0;
        //initial
        int len = A.length;
        dp = new int[2*len][2*len];
        sum = new int[2*len+1];
        flag = new int[2*len][2*len];
        for (int i = 0; i < 2*len; i++) {
            dp[i][i] = 0;
            flag[i][i] = 1;
            sum[i+1] = sum[i] + A[i%len];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, find(A, i, i+len-1));    
        }
        return min;
    }
    private int find(int[]A, int i, int j) {
        if (flag[i][j] == 1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, find(A, i, k)+ find(A, k+1,j));
        }
        dp[i][j] = min + sum[j+1]-sum[i];
        flag[i][j] = 1;
        return dp[i][j];
    }
}
