
public class A005_LongestPalindromicSubstring {
/*	// Naive Solution
  	public static String longestPalindrome(String s) {
 
        int BGN = 0;
        int maxLength = s.length() + 1;
        
        while (maxLength > 0) {
        	maxLength --;
        	
        	for (int i = 0; i <= s.length() - maxLength; i++) {
        		String sub = s.substring(i, i + maxLength);
//        		System.out.println(sub);
        		if (sub.charAt(0) == sub.charAt(maxLength - 1) && isPalindromic(sub)) return sub; 
        	}
        }
		
		return "";
    }
	
	public static boolean isPalindromic(String s) {
		int length = s.length();
	
		if (length % 2 == 1) {
			int pivot = (length + 1) / 2 - 1;
			
			for (int i = 1; i <= pivot; i++) {
				if (s.charAt(pivot - i) != s.charAt(pivot + i)) {
					return false;
				}
			}
			
			return true;
		}
		else {
			int pivot1 = length / 2 - 1;
			int pivot2 = pivot1 + 1;
			
			for (int i = 0; i <= pivot1; i++) {
				if (s.charAt(pivot1 - i) != s.charAt(pivot2 + i)) { 
					return false;
				}
			}
			
			return true;
		}
	}
*/
	
	public static String longestPalindrome(String s) {
		int strLen = s.length();
		
		if (strLen < 2) return s;
		
		int maxLen = 0;
		String output = "";

		for (int i = 0; i < strLen - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				// Found two consecutive position with same char;
				// Base for Palindrome String.
//				System.out.println("Two consecutive chars found " + s.charAt(i));
				
				int extend = 0;
				while (i - extend >= 0 && i + 1 + extend < strLen && s.charAt(i - extend) == s.charAt(i + 1 + extend)) {
					if (2 * extend + 2 > maxLen) {
						maxLen = 2 * extend + 2;
						output = s.substring(i - extend, i - extend + maxLen);
//						System.out.println("Symmetric String found " + output);
					}
					
					extend ++;
				}
			}
		}
		
		for (int i = maxLen / 2; i < strLen - maxLen / 2; i ++) {
			int extend = 0;
			
			while (i - extend >= 0 && i + extend < strLen && s.charAt(i - extend) == s.charAt(i + extend)) {
				if (2 * extend + 1 > maxLen) {
					maxLen = 2 * extend + 1;
					output = s.substring(i - extend, i + extend + 1);
//					System.out.println("Symmetric String found " + output);
				}
				
				extend ++;
			}
		}
		
		
		
		return output;
	}

	
	public static void main(String[] args) {
		String s = "abcda";
		String output = longestPalindrome(s);
		System.out.println("Longest Palindrome SubString\t" + output);
	}
}
