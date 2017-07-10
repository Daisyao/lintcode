
import java.util.HashSet;
import java.util.Set;

public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> temp = new HashSet<Integer>();
        int value = n;
        while (true) {
            value = sumOfSquareDigits(value);
            if (!temp.contains(value)) {
                temp.add(value);
            }
            else 
                break;
        }
        if (value == 1)
            return true;
        else
            return false;
        
    }
    private int sumOfSquareDigits(int n) {
        int result = 0;
        for (int i = n; i > 0; i = i/10) {
            result = result + (i%10)*(i%10);
        }
        return result;
    }
}
