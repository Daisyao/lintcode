import java.util.ArrayList;
import java.util.List;

public class Solution390 {
	public List<Integer> findPeakII(int[][] A) {
        // write your code here
		List<Integer> ans = new ArrayList<Integer>();
		if (A == null || A.length < 3 || A[0].length < 3) return ans;
		int left = 1; int right = A[0].length - 2;
		int upper = 1; int down = A.length -2;
		int[] pos = new int[2]; //pos[0] x; pos[1] y;
		pos = findLine(A, left, right, upper, down);
		ans.add(pos[0]);
		ans.add(pos[1]);
		return ans;
    }
	private int[] findLine(int[][] A, int left, int right,int upper, int down) {
		int location = upper + (down - upper)/2;
		int[] pos = new int[2];
		pos[0] = location;
		int max = 0;
		for (int i = left; i < right + 1; i++) {
			if (A[location][i] > max) {
				pos[1] = i;
				max = A[location][i];
			}
		}
		System.out.println("find line");
		System.out.println(pos[0]);
		System.out.println(pos[1]);
		System.out.println(max);
		System.out.println();
		if (A[location -1][pos[1]] < max && A[location + 1][pos[1]] < max) {
			return pos;
		}
		if (A[location + 1][pos[1]] > max) {
			return findRow(A, location + 1, down, left, right);
		} else {
			return findRow(A, upper, location -1, left, right);
		}
	}
	private int[] findRow(int[][]A, int upper, int down, int left, int right) {
		int location = left + (right - left) / 2;
		int[] pos = new int[2];
		pos[1] = location;
		int max = 0;
		for (int i = upper; i < down + 1; i++) {
			if (A[i][location] > max) {
				pos[0] = i;
				max = A[i][location];
			}
		}
		System.out.println("find row");
		System.out.println(pos[0]);
		System.out.println(pos[1]);
		System.out.println();
		if (A[pos[0]][location - 1] < max && A[pos[0]][location + 1] < max) {
			return pos;
		}
		if (A[pos[0]][location - 1] > max) {
			return findLine(A, left, location -1, upper, down);
		} else {
			return findLine(A, location + 1, right, upper, down);
		}
	}
}
