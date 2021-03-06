
public class Solution168 {
	int[][] dp;
    int[][] flag;
   public int maxCoins(int[] nums) {
       // Write your code here
       if (nums == null || nums.length == 0) return 0;
       int len = nums.length;
       int[] newnums = new int[len+2];
       newnums[0] = 1;
       newnums[len+1] = 1;
       for (int i = 0; i < len; i++) {
           newnums[i+1] = nums[i];
       }
       dp = new int[len][len];
       flag = new int[len][len];
       //initial
       for (int i = 0; i < len; i++) {
           dp[i][i] = newnums[i+1] *newnums[i] * newnums[i+2];
           flag[i][i] = 1;

           System.out.println(String.format("i is %d, j is %d, dp is %d", i, i, dp[i][i]));
       }
       return find(newnums, 2, 3);
   }
   private int find(int[] newnums, int i, int j) {
       if (j < i) return 0;
       if (flag[i][j] == 1) return dp[i][j];
       int max = Integer.MIN_VALUE;
       for (int k = i; k <= j; k++) {
           max = Math.max(max, find(newnums, i, k-1) + find(newnums, k+1, j) + newnums[i]*newnums[k+1]*newnums[j+2]);
       }
       flag[i][j] = 1;
       dp[i][j] = max;
       System.out.println(String.format("i is %d, j is %d, dp is %d", i, j, dp[i][j]));
       return max;
   }
}
