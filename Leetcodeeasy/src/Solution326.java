
public class Solution326 {
	public boolean isPowerOfThree(int n) {
		/**
		 * recursive way
		 */
		/*
        if (n == 1) return true;
        if (n < 1 || n%3 != 0) return false;
        return isPowerOfThree(n/3);
        */
		/**
		 * without loop or recursion
		 */
		if (n <1) return false;
		while (n > 1) {
			if (n%3 != 0) {
				return false;
			}
			n = n/3;
		}
		if (n != 1) return false;
		
		return true;
    }
}
