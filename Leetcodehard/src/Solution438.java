
public class Solution438 {
	public int copyBooksII(int n, int[] times) {
        // write your code here
        if (n == 0 || times.length == 0) {
            return 0;
        }
        int start = 1; 
        int end = Integer.MAX_VALUE;
        while (start + 1 < end) {
            int mid = start + (end -start)/2;
            long count = 0;
            for (int i = 0; i < times.length; i++) {
                count += mid/times[i];
            }
            System.out.println(String.format("mid is %d, count is %d", mid, count));
            if (count < n) start = mid;
            else end = mid;
        }
        int count = 0;
        for (int i = 0; i < times.length; i++) {
            count += start/times[i];
        }
        if (count >= n) return start;
        else return end;
    }
}
