
public class Solution032 {
	int[] targetMap = new int[256];
    int[] sourceMap = new int[256];
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        String result = "";
        int minWin = source.length() + 1;
        int j = 0;
        for (int i = 0; i < target.length(); i++) {
        	//System.out.println(target.charAt(i));
            targetMap[target.charAt(i)]++;
        }
        for (int i = 0; i < source.length(); i++) {
        	//judge = window(source,target);
            while (j < source.length() && !window(source,target)) {
                if (targetMap[source.charAt(j)] > 0) {
                    sourceMap[source.charAt(j)]++;
                }
                j++;
            }
            //update
            if (window(source,target)) {
            	//System.out.println(source.substring(i, j));
                if (minWin > j - i) {
                    minWin = j - i;
                    result = source.substring(i, j);
                }
            }
            if (sourceMap[source.charAt(i)] > 0) {
                sourceMap[source.charAt(i)]--;
            }
        }
        return result;
    }

    private boolean window(String source, String target) {
        for (int i = 0; i < sourceMap.length; i++) {
            if (targetMap[i] > sourceMap[i]) {
                return false;
            }
        }
        return true;
    }
}
