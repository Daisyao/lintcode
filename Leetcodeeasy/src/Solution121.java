
public class Solution121 {
	public int maxPorfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int buy = prices[0];
		int sell = buy;
		int result = 0;
		for (int i = 1; i< prices.length; i++) {
			if (prices[i] > sell) {
				sell = prices[i];
				result = Math.max(sell - buy, result);
			} else if (prices[i]> buy){
				continue;
			} else {
				buy = prices[i];
				sell = buy;
			}			
		}
		return result;
	}
}
