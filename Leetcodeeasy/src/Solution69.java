
public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int low = 1; int upper = x;
        int mid = 1;
        while (low <= upper) {
            mid = low + (upper - low) /2;
            if (mid == x/mid) return mid;
            if (mid < x/mid) {
                if (mid+1 > x/(mid+1))
                    return mid;
                else 
                    low = mid + 1;
            } else {
                upper = mid -1;
            }
        }
        return mid;
    }
}
