
public class Solution9 {
	public boolean isPalindrome(int x) {
		if (x < 0) return false;
		if (x == 0 )return true;
		int base = 1;
		while (x/base/10 !=0) {
			base *= 10;
		}
		while (x!=0) {
			
			if (x/(base) != x%10) {
				return false;
			} else {
				x = (x-(x%10)*base)/10;
				base = base/100;
			}
		}
		return true;
	}
}
