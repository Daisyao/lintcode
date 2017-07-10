
public class Solution191 {
	public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;
        
        int posMin = 1;
        int negMax = 1;
        int[] product = new int[nums.length + 1];
        product[0] = 1;
        int max = nums[0];
        for (int i = 1 ; i < product.length; i++) {
            if (nums[i-1] == 0) {
                max = Math.max(0, max);
                product[i] = 1;
                posMin = 1;
                negMax = 1;
            } else {
                product[i] = product[i-1] * nums[i-1];
                if (product[i]>0) {
                    max = Math.max(product[i] / posMin, max);
                    posMin = Math.min(product[i], posMin);
                } else {
                    max = Math.max(product[i] / negMax, max);
                    if (negMax < 0) {
                        negMax = Math.max(product[i], negMax);
                    } else {
                        negMax = product[i];
                    }
                }
            }
        }
        return max;
    }
}
