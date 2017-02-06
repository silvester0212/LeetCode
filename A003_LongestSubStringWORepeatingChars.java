import java.util.HashMap;

public class A003_LongestSubStringWORepeatingChars {
	public static int lengthOfLongestSubstring_NAIVE(String s) {
		StringBuilder LongestSubString = new StringBuilder();
		int maxLength = 0;

		for (int i = 0; i < s.length(); i++) {
			StringBuilder CurrentSubString = new StringBuilder();
			int curLength = 0;
			
			for (int j = 0; j <= s.length() - (i+1); j++) {
//				System.out.println("Current char " + s.charAt(i+j) + " at Position " + (i+j));
				
				if (! CurrentSubString.toString().contains(s.substring(i + j, i + j + 1))) {
//					System.out.println("Iteration entering IF...");
					CurrentSubString.append(s.charAt(i+j));
					curLength ++;
					
					if (curLength > maxLength) {
						maxLength = curLength;
						LongestSubString = CurrentSubString;
					}
				}
				else {
//					System.out.println("Iteration entering ELSE...");
					CurrentSubString = new StringBuilder();
					curLength = 0;
					break;
				}
				
//				System.out.println("Longest SubStr " + LongestSubstring.toString());
//				System.out.println("Current SubStr " + CurrentSubString.toString() + "\n");
			}
		}
		
		return maxLength;
	}
	
	public static int lengthOfLongestSubstring_ONSQ(String s) {
		// O(n) to read input string; O(n) to search for non-repeating chars.
		StringBuilder LongestSubString = new StringBuilder();
		StringBuilder CurrentSubString = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
//			System.out.println("Current char " + s.charAt(i) + " at Position " + (i));
			
			int pos = posCharFromString(s.charAt(i), CurrentSubString.toString());
			
			// Char not present in string
			if (pos == -1)	{
//				System.out.println("Char not found at Position " + pos + " - Iteration entering IF...");
			}
			// Char present in string
			else {
//				System.out.println("Char found at Position " + pos + " - Iteration entering ELSE...");
				
				String PreviousStr = CurrentSubString.toString();
				CurrentSubString = new StringBuilder(PreviousStr.substring(pos + 1, PreviousStr.length()));
			}
			
			CurrentSubString.append(s.charAt(i));
			
			if (CurrentSubString.length() > LongestSubString.length()) {
				LongestSubString = CurrentSubString;
			}
			
//			System.out.println("Longest SubStr " + LongestSubString.toString());
//			System.out.println("Current SubStr " + CurrentSubString.toString() + "\n");
		}
		
		return LongestSubString.toString().length();

	}
	
	public static int lengthOfLongestSubstring(String s) {
		// O(n) to read input string
		int leftPointer = 0;
		int rightPointer = -1;
		int maxLength = 0;
		int maxStringLeftIdx = -1;
		int maxStringRightIdx = -1;
		HashMap<Character, Integer> HMap = new HashMap<Character, Integer>();
		
		for (int i = 0; i < s.length(); i++) {
//			System.out.println("Current char " + s.charAt(i) + " at Position " + (i));
			if (! HMap.containsKey(s.charAt(i))) {
//				System.out.println("Iteration entering IF...");
				HMap.put(s.charAt(i), i);
				rightPointer = i + 1;
			}
			else {
//				System.out.println("Iteration entering ELSE...");
				int newLeftPointer = HMap.get(s.charAt(i)) + 1;

				for (int j = leftPointer; j < newLeftPointer; j++) {
					HMap.remove(s.charAt(j));
				}
				HMap.put(s.charAt(i), i);				
				leftPointer = newLeftPointer;
				rightPointer = i+1;
			}
			
			int curLength = rightPointer - leftPointer;
			if (curLength > maxLength) {
				maxStringLeftIdx = leftPointer;
				maxStringRightIdx = rightPointer;
				maxLength = curLength;
			}
			
/*			System.out.println("Longest Left Pointer " + maxStringLeftIdx);
			System.out.println("Longest Right Pointer " + maxStringRightIdx);
			System.out.println("Longest SubStr " + s.substring(maxStringLeftIdx, maxStringRightIdx));
			System.out.println("Current Left Pointer " + leftPointer);
			System.out.println("Current Right Pointer " + rightPointer);
			System.out.println("Current SubStr " + s.substring(leftPointer, rightPointer)+ "\n");
*/		}
		
		return maxLength;

	}
	
	public static int posCharFromString(char c, String s) {
		for (int i = 0; i < s.length(); i++) {
			if (c == s.charAt(i)) return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		String input = "abcabcbb";
		
		System.out.println(lengthOfLongestSubstring(input));
	}
}
