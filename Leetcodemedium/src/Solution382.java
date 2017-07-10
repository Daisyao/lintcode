import java.util.Arrays;

public class Solution382 {
	public int triangleCount(int S[]) {
        // write your code here
		if (S.length < 3) return 0;
		Arrays.sort(S);
		int count = 0;
		for (int k = 2; k < S.length; k++) {
			int i = 0; 
			int j = k -1;
			while (i < j) {
				if (S[i] + S[j] > S[k]) {
					count += j - i;
					j--;
				} else {
					i++;
				}
			}
		}
		return count;
    }
}
