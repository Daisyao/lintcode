
public class Solution125 {
	public boolean isPalindrome(String s) {
		//if (s == null || s.length() == 0) return true;
		s = s.toLowerCase();
		char[] valid = new char[s.length()];
		int count = 0;;
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i)>='A' && s.charAt(i)<='Z') || 
					(s.charAt(i)>='a' && s.charAt(i)<='z') || 
					(s.charAt(i)>='0' && s.charAt(i)<='9')) {
				valid[count] = s.charAt(i);
				count++;
			}
		}
		if (count == 0) return true;
		for (int i = 0; i <= (count-1)/2; i++) {
			if (valid[i] !=valid[count-1-i]) {
				return false;
			}
		}
		return true;
	}
}
