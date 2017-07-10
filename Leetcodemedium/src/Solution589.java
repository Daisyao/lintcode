
public class Solution589 {
	int[] father;
    public Solution589(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            father[i] = i;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int fa = find_father(a);
        int fb = find_father(b);
        if (fa != fb) {
            father[fa] = fb;
        }
    }
    
    private int find_father(int x) {
        if (father[x] == x) return x;
        return father[x] = find_father(father[x]);
    }
        
    public boolean  query(int a, int b) {
        // Write your code here
        if (find_father(a) == find_father(b)) {
            return true;
        }
        return false;
    }
}
