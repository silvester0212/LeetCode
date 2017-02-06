
public class A050_Power_X_n {
	public static int totalCalls = 0;
	
	public static double myPow(double x, int n) {
		totalCalls ++;
		
		if (x == 1.0) return 1.0;
/*		
		if (n == Integer.MAX_VALUE) {
			if ( x > 1.0 ) return Double.POSITIVE_INFINITY;
			else return 0.0;
		}
		else if (n == Integer.MIN_VALUE) {
			if ( x > 1.0 ) return 0.0;
			else return Double.POSITIVE_INFINITY;
		}
*/		
		if (n == 1) return x;
		if (n == 0) return 1;
		
		
		if (n < 0){
			if (n == Integer.MIN_VALUE) n = Integer.MAX_VALUE - 1;
			else n = -n;
			x = 1.0 / x;
		}
		
		if (n % 2 == 1) {
			int subPower = (n - 1) / 2;
			
			double subResult = myPow(x, subPower);
			return subResult * subResult * x;
				
//			return x * myPow(x * x, (n - 1) / 2);
		}
		else {
			int subPower = n / 2;
			
			double subResult = myPow(x, subPower);
			return subResult * subResult;
//			return myPow(x * x, n / 2);
		}
		
    }
	
	public static double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
    }
	
	public static void main(String[] args) {
		System.out.println(myPow(-1.0, -2147483648)  + " calculated in " + totalCalls + " calls.");
	}
}
