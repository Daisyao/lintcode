
public class Solution28 {
	public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int point1 = 0;
        int point2 = n;
        int start = 0; 
        int end = m - 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (target < matrix[mid][point1]) {
                end = mid - 1;
            } else if (target > matrix[mid][point2]) {
                start = mid + 1;
            } else {
                start = mid;
                break;
            }
        }
        while (point1 < point2) {
            int mid = point1 + (point2 - point1) /2;
            if (target < matrix[start][mid]) {
                point2 = mid -1;
            } else if (target > matrix[start][mid]){
                point1 = mid + 1;
            } else {
                return true;
            }
        }
        if (target == matrix[start][point1]) {
            return true;
        }
        return false;
    }
}
