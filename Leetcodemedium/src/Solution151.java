
public class Solution151 {
	public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) return 0;

        int max = 0;
        int len = prices.length;
        int[] premax = new int[len];
        int[] preindex = new int[len];
        int[] postmax = new int[len];
        int[] postindex = new int[len];
        
        int i = 0;
            for (int j = i + 1; j < len; j++) {
                if (prices[j] < prices[preindex[j-1]]) {
                    preindex[j] = j;
                    premax[j] = premax[j-1];
                    continue;
                }
                if (prices[j] - prices[preindex[j-1]] > premax[j-1]) {
                    premax[j] = prices[j] - prices[preindex[j-1]];
                    preindex[j] = preindex[j-1];
                } else {
                	premax[j] = premax[j-1];
                	preindex[j] = preindex[j-1];
                }
            }
            
        i = len -1;
        postindex[i] = i;
        for (int j = i-1; j >=0; j--) {
            if (prices[j]> prices[postindex[j+1]]) {
                postindex[j] = j;
                postmax[j] = postmax[j+1];
                continue;
            }
            if (prices[postindex[j+1]]-prices[j]>postmax[j+1]) {
                postmax[j] = prices[postindex[j+1]]-prices[j];
                postindex[j] = postindex[j+1];
                continue;
            }else {
            	postmax[j] = postmax[j+1];
            	postindex[j] = postindex[j+1];
            }
        }
        
        for (i = 0; i < len; i++) {
            if (premax[i] + postmax[i] > max) {
                max = premax[i] + postmax[i];
            }
        }
        return max;
    }
}
