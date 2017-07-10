
public class Solution62 {
	 public int search(int[] A, int target) {
	        // write your code here
	        if (A == null || A.length == 0) return -1;
	        int start = 0;
	        int end = A.length - 1;
	        int minIndex = findMin(start, end, A);
	        System.out.println(minIndex);
	        if (minIndex != 0) {
	        	if (target == A[start]) return 0;
		        if (target < A[start]) {
		            start = minIndex;
		        } else {
		            end = minIndex - 1;
		        }
	        }
	        while (start <= end) {
	            int mid = start + (end - start) / 2;
	            if (A[mid] == target) {
	                return mid;
	            }
	            if (A[mid] < target) {
	                start = mid + 1;
	            } else {
	                end = mid - 1;
	            }
	        }
	        return -1;
	    }
	    private int findMin(int start, int end, int[] A) {
	      
	        while (start + 1 < end) {
	        	int mid = start + (end - start) / 2;
	            if (A[mid] < A[mid - 1]) {
	                return mid;
	            }
	            if (A[mid] < A[end]) {
	                end = mid - 1;
	            } else {
	                start = mid + 1;
	            }
	        }
	        if (A[start] < A[end]) {
	            return start;
	        }
	        return end;
	    }
}
