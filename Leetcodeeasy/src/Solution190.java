
public class Solution190 {
	public int reverseBits(int n) {
		int reverse = 0;
		for (int i = 0; i < 32; i++) {
			if (n%2 == 0) {
				reverse= reverse*2;
			} else {
				reverse= reverse*2 +1;
			}
			n = n>>>1;
		}
		return reverse;
	}
}
