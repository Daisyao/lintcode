
public class Solution13 {
    //I 1 V5 X10 L50 C100 D500 M1000
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    result = result +1;
                    break;
                case 'V':
                    result = result + 5;
                    break;
                case 'X':
                    result = result + 10;
                    break;
                case 'L':
                    result = result + 50;
                    break;
                case 'C':
                    result = result + 100;
                    break;
                case 'D':
                    result = result + 500;
                    break;
                case 'M':
                    result = result + 1000;
                    break;
                default:
                    break;
            }
        }
        if (s.indexOf("IV") != -1) 
            result -=2;
        if (s.indexOf("IX") != -1)
            result -=2;
        if (s.indexOf("XL") != -1)
            result -=20;
        if (s.indexOf("XC") != -1)
            result -=20;
        if (s.indexOf("CM") != -1)
            result -=200;
        if (s.indexOf("CD") != -1)
            result -=200;
        
        return result;
    }
}
