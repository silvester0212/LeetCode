
public class A014_LongestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
		StringBuilder prefix = new StringBuilder();
		
		if (strs == null || strs.length == 0) return "";
//		else if (strs.length == 1) return strs[0];
		
		int pointer = -1;
		boolean stop = false;
		
		while (! stop) {
			pointer ++;
			
			if (pointer >= strs[0].length()) break;
			char c = strs[0].charAt(pointer);
			
			for(int i = 1; i < strs.length; i++) {
				if (pointer >= strs[i].length()) {
					stop = true;
					break;
				}
				if (strs[i].charAt(pointer) != c) {
					stop = true;
					break;
				}
			}
			
			if (!stop) prefix.append(c);
		}
		
		return prefix.toString();
	}
	
	public static void main(String[] args) {
		String[] input = new String[] {
				"",
				""
		};
		
		System.out.println(longestCommonPrefix(input));
	}
}
