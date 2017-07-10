
public class Solution75 {
	public int findPeak(int[] A) {
        // write your code here
        if (A.length < 3) return -1;
        int start = 0;
        int end = A.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid -1] && A[mid] > A[mid + 1]) {
                return mid;
            }
            if (A[mid] < A[mid -1] && A[mid] > A[mid + 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (A[start] > A[end]) {
            return start;
        } else {
            return end;
        }
    }
}
