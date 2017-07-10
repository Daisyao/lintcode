
public class Solution66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newdigits = new int[digits.length+1];
        newdigits[0] = 1;
        for (int i = 1; i < newdigits.length; i++) {
            newdigits[i] = digits[i-1];
        }
        return newdigits;
    }
}
