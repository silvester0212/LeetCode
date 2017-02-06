
public class A006_ZigZagConversion {
	public static String convert(String s, int numRows) {
		if (s.length() == 0) return s;
		else if (numRows == 1) return s;

		StringBuilder[] sbs = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) sbs[i] = new StringBuilder();
		int Row = -1;
		boolean goingDown = true;
		
		for (int i = 0; i < s.length(); i++) {
			
			if (Row == numRows - 1 && goingDown == true) goingDown = false;
			else if (Row == 0 && goingDown == false) goingDown = true;
			
			if (goingDown) {
				Row ++;
				sbs[Row].append(s.charAt(i));
			}
			else {
				Row --;
				sbs[Row].append(s.charAt(i));
			}
			
			
		}
		
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < numRows; i++) output.append(sbs[i]);
		
		return output.toString();
    }
	
	public static void main (String[] args) {
		String string = "PAYPALISHIRING";
		int numRows = 2;
		System.out.println(convert(string, numRows));
	}
}
