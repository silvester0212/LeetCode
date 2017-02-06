
public class A007_ReverseInteger {
	public static long reverse(int x) {
        int sign = 0;
        long input = (long) x;
		
		if (x == 0) return 0;
        else if (x > 0) {
        	sign = 1;
        }
        else {
        	sign = -1;
        	input = - input;
        }
		
		long result = 0;		
		while( input != 0 ) {
			int digit = (int) (input % 10);
			input = (input - digit) / 10;
			
			result = (result + digit) * 10;
		}
		
		result /= 10;
		result = sign * result;
		
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
		else return (int) result;
    }
	
	public static void main(String[] args) {
		int x = 78123580;
		System.out.println(reverse(x));
	}
}
