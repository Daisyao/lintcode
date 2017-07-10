
public class Solution122 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) return 0;
		int buy = prices[0];
		int sell = buy;
		int newbuy = buy;
		int result = 0;
		for (int i = 1; i< prices.length; i++) {
			buy = newbuy;
			//find min			
			for (; i < prices.length; i++) {				
				if (prices[i] < buy) {
					buy = prices[i];
				} else {
					break;
				}
			}
			//find max
			sell = buy;
			for (; i < prices.length; i++) {
				if (sell < prices[i]) {
					sell = prices[i];
				} else {
					newbuy = prices[i];
					break;
				}
			}
			//result++ 
			result = result + sell - buy;
			
		}
		return result;
	}
}
