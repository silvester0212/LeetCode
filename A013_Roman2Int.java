import java.util.ArrayList;
import java.util.HashMap;

public class A013_Roman2Int {
	public static int romanToInt(String s) {

		HashMap<Character, Integer> RomanNumMap = new HashMap<Character, Integer>();
		RomanNumMap.put('M', 1000);
		RomanNumMap.put('D', 500);
		RomanNumMap.put('C', 100);
		RomanNumMap.put('L', 50);
		RomanNumMap.put('X', 10);
		RomanNumMap.put('V', 5);
		RomanNumMap.put('I', 1);
		
		
		int r = 0;
		
		for(int i = 0; i < s.length(); i++) {
			int curInt = RomanNumMap.get(s.charAt(i));
			
			if (i == s.length() - 1) r += curInt;
			else {
				int nextInt = RomanNumMap.get(s.charAt(i + 1));
				
				if (curInt < nextInt) {
					r -= curInt;
					r += nextInt;
					i++;
				}
				else r += curInt;
			}
		}
		
         return r;
    }
	
	public static void main(String[] args) {
		for (int i = 1; i <= 3999; i++) {
			int input = i;
			String RomanNum = A012_Int2Roman.intToRoman(input);
			int output = romanToInt(RomanNum);
			
			if (input != output) {
				System.out.println("Roman Number " + RomanNum + " not translated into " + input);
				break;
			}
		}
		
		System.out.println("Done");
	}
}
