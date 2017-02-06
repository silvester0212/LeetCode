import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A017_LetterCombinationOfPhoneNum {
	public static List<String> letterCombinations(String digits) {
		ArrayList<String> r = new ArrayList<String>();
	
		if (digits.length() == 0) return new ArrayList<String>();
		
		String[] digitMap = new String[] {
				"0",
				"1",
				"abc",
				"def",
				"ghi",
				"jkl",
				"mno",
				"pqrs",
				"tuv",
				"wxyz"
		};
		
		char c = digits.charAt(0);
		String cMap = digitMap[c - '0'];
		for (int j = 0; j < cMap.length(); j++) r.add(cMap.charAt(j) + "");
		
		for (int i = 1; i < digits.length(); i++) {
			c = digits.charAt(i);
			cMap = digitMap[c - '0'];
			
			ArrayList<String> newList = new ArrayList<String>();
			for (int j = 0; j < r.size(); j++) {
				for (int k = 0; k < cMap.length(); k++) {
					newList.add(r.get(j) + cMap.charAt(k));
				}
			}
			
			r = newList;
		}
		
		return r;
	}
	
	public static void main(String[] args) {
		String input = "2345";
		System.out.println(letterCombinations(input));
	}
}
