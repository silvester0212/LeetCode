
public class A028_ImplementStrStr {
	public static int strStr(String haystack, String needle) {
		if (needle.equals("")) return 0;
		
		int haystackLen = haystack.length();
		int needleLen = needle.length();
		
		if (haystackLen < needleLen) return -1;
		
		int p = 31;
		int x = 13;
		
//		long needleHash = needleHash(needle, p, x);
		long needleHash = 0;
		for (int i = 0; i < needleLen; i++) {
			int charHash = (int) needle.charAt(i);
			needleHash += charHash * Math.pow(x, i);
		}
		
//		long[] haystackHashSet = haystackHashSet(haystack, needle.length(), p, x);
		
		long[] haystackHashSet = new long[haystackLen - needleLen + 1];
		
		haystackHashSet[0] = 0;
		for(int i = 0; i < needleLen; i++) {
			int charHash = (int) haystack.charAt(i);
			haystackHashSet[0] += charHash * Math.pow(x, i);
		}
		
		for (int i = 0; i < haystackHashSet.length; i++) {
			if (i > 0) {
				long excludledChar = haystack.charAt(i - 1);
				long includedChar = haystack.charAt(i - 1 + needleLen);
				haystackHashSet[i] = (long) (( haystackHashSet[i-1] - excludledChar ) / x + includedChar * Math.pow(x, needleLen - 1));
			}
			
			if (haystackHashSet[i] == needleHash && StringChar2CharCompare(haystack.substring(i, i + needleLen), needle)) return i;
		}
		
		return -1;
	}
	
	public static boolean StringChar2CharCompare(String a, String b) {
		if (a.length() != b.length()) return false;
		
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) return false;
		}
		
		return true;
	}
	
	public static long needleHash(String input, int p, int x) {
		long r = 0;
		
		for (int i = 0; i < input.length(); i++) {
			int charHash = (int) input.charAt(i);
			r += charHash * Math.pow(x, i);
		}
		
		return r;
	}
	
	public static long[] haystackHashSet(String haystack, int subLength, int p, int x) {
		long[] r = new long[haystack.length() - subLength + 1];
		
		long val = 0;
		for(int i = 0; i < subLength; i++) {
			int charHash = (int) haystack.charAt(i);
			val += charHash * Math.pow(x, i);
		}
		r[0] = val;
		
		for (int i = 1; i < r.length; i++) {
			long excludledChar = haystack.charAt(i - 1);
			long includedChar = haystack.charAt(i - 1 + subLength);
			r[i] = (long) (( r[i-1] - excludledChar ) / x + includedChar * Math.pow(x, subLength - 1));
		}
		
		return r;
	}
	
	public static void main(String[] args) {
		String haystack = "daabcababcdefghijklmnopqrstuvwxyzcabcabd";
		String needle = "abcdefghijklmnopqrstuvwxyz";
		System.out.println(strStr(haystack, needle));
	}
}
