
import java.util.ArrayList;

public class Solution7 {
    public int reverse(int x) {
        long temp = 0;
        ArrayList<Integer> array = new ArrayList<Integer>();
        while (x != 0) {
            array.add(x%10);
            x = x/10;
        }
        for (int i= 0; i < array.size(); i++) {
            temp = temp*10 + array.get(i);
        }
        if (temp > 0 && temp > (long)Integer.MAX_VALUE) {
            return 0;
        }
        if (temp < 0 && temp < (long)Integer.MIN_VALUE) {
            return 0;
        }
        return (int)temp;
    }
}
