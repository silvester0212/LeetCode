import java.util.ArrayList;

public class A012_Int2Roman {
	public static class RomanNum {
		int Num;
		String RomanNum;
		
		public RomanNum(String rn, int n) {
			Num = n;
			RomanNum = rn;
		}
		
		public static ArrayList<RomanNum> getRomanNumMap() {
			ArrayList<RomanNum> map = new ArrayList<RomanNum>();
			
			map.add(new RomanNum("M", 1000));
			map.add(new RomanNum("CM", 900));
			map.add(new RomanNum("D", 500));
			map.add(new RomanNum("C", 100));
			map.add(new RomanNum("XC", 90));
			map.add(new RomanNum("L", 50));
			map.add(new RomanNum("X", 10));
			map.add(new RomanNum("IX", 9));
			map.add(new RomanNum("V", 5));
			map.add(new RomanNum("I", 1));
			
			return map;
		}
	}
	
	public static String intToRoman(int num) {
		StringBuilder output = new StringBuilder();
		ArrayList<RomanNum> RomanNumMap = RomanNum.getRomanNumMap();
		
		for (int i = 0; i < RomanNumMap.size(); i++) {
			if (num == 0) break;
			
			RomanNum curRNum = RomanNumMap.get(i);
			int ratio = num / curRNum.Num;
			
//			System.out.println("Current Num " + num + "\nCurrent Roman Num " + curRNum.Num + "\nCurrent Ratio " + ratio);
			
			if (ratio > 0 && ratio <= 3) {
				num = num - ratio * curRNum.Num;
				for (int j = 1; j <= ratio; j++) {
					output.append(curRNum.RomanNum);
				}
			}
			else if (ratio == 4) {
				int small = curRNum.Num;
				RomanNum largerRNum = RomanNumMap.get(i-1);
				int large = largerRNum.Num;
				
				if (large - small == ratio * curRNum.Num) {
					output.append(curRNum.RomanNum);
					output.append(largerRNum.RomanNum);
					num = num - (largerRNum.Num - curRNum.Num);
				}
				else {
					System.out.println("Adjust Error occurred for Num " + num);
				}
			}
			else if (ratio == 0) continue;
			else System.out.println("Ratio Error occurred for Num " + num);
		}
		
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 3999; i++) {
			int input = i;
			System.out.println("Num " + i + " Roman Num " + intToRoman(input));
		}
	}
}
