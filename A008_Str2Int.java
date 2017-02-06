
public class A008_Str2Int {
	public static int myAtoi(String str) {
		long output = 0;
		int sign = 1;
		
		int i = 0;
		
		str = str.trim();
		if (str.isEmpty()) return 0;
		
		if (str.charAt(i) == '+' || str.charAt(i) == '-') {
			sign = str.charAt(i) == '+' ? 1 : -1;
			i++;
		}

		
		for (; i < str.length(); i++) {
			int digit = str.charAt(i) - '0';
				
			if (digit < 0 || digit > 9) break;
			else output = output * 10 + digit;

			if (output * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			else if (output * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		}
		
		output = output * sign;
		if (output > Integer.MAX_VALUE) return Integer.MAX_VALUE;
		else if (output < Integer.MIN_VALUE) return Integer.MIN_VALUE;
		else return (int) output;
    }
	
	public static void main(String[] args) {
/*		while (true) {
			int random = 0;
			
			if (Math.random() > 0.5) random = (int) (Integer.MAX_VALUE * Math.random());
			else random = (int) (Integer.MIN_VALUE * Math.random());
			
			if (myAtoi(random + "") != random) {
				System.out.println(random + " not being translated");
			}
		}
*/
		System.out.println(myAtoi("   +-+ "));
	}
	

}
