
public class Solution433 {
	int size;
    int[] father;
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        father = new int[m * n];
        size = 0;
        
        //initial
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    father[i * n + j] = i * n + j;
                    size ++;
                }
            }
        }
        //connect adjacent island
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]) {
                    if (i > 0 && grid[i-1][j]) {
                        connect(i * n + j, (i-1) * n + j);
                    }
                    if (i < n - 1 && grid[i + 1][j]) {
                        connect(i * n + j, (i + 1) * n + j);
                    }
                    if (j > 0 && grid[i][j - 1]) {
                        connect(i * n + j, i * n + j - 1);
                    }
                    if (j > 0 && grid[i][j + 1]) {
                        connect(i * n + j, i * n + j + 1);
                    }
                }
            }
        }
        return size;
        
    }
    private void connect(int a, int b) {
        // Write your code here
        int fa = find_father(a);
        int fb = find_father(b);
        if (fa != fb) {
            father[fa] = fb;
            size--;
        }
    }
    
    private int find_father(int x) {
        if (father[x] == x) return x;
        return father[x] = find_father(father[x]);
    }
}
