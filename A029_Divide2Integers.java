import java.util.ArrayList;
import java.util.HashMap;


public class A029_Divide2Integers {
	public static class P2M {
		long ratio;
		long multiple;
		
		public P2M (long r, long m) {
			ratio = r;
			multiple = m;
		}
	}
	
	public static int divide(int dividend, int divisor) {
		if (divisor == 0) return Integer.MAX_VALUE;
		if (dividend == 0 && divisor != 0) return 0;
		if (divisor == 1) return dividend;
//		if (divisor == -1) return -dividend;
		
		int sign1 = 0, sign2 = 0;
		long dividendL = dividend;
		long divisorL = divisor;
		
		if (dividend > 0) sign1 = 1;
		else {
			sign1 = -1;
			dividendL = -dividendL;
		}
		
		if (divisor > 0) sign2 = 1;
		else {
			sign2 = -1;
			divisorL = -divisorL;
		}
		 
		System.out.println("Dividend " + dividendL + " Divisor " + divisorL);
		if (dividendL < divisorL) return 0;
		
		int signR = sign1 * sign2;
		
		long ratio = 1;
		long multiple = divisorL;
		ArrayList<P2M> Power2Multiple = new ArrayList<P2M>();
		
		while (multiple <= dividendL) {
			Power2Multiple.add(new P2M(ratio, multiple));

			ratio = ratio + ratio;
			multiple = multiple + multiple;
		}
		
		long r = 0;
//		System.out.println("ArrayList size " + Power2Multiple.size());
		int i = Power2Multiple.size() - 1;
		while (dividendL >= divisorL) {
			while (Power2Multiple.get(i).multiple > dividendL && i > 0) {
				i--;
			}
			
//			System.out.println("P2M Found: Ratio " + Power2Multiple.get(i).ratio + " Multiple " + Power2Multiple.get(i).multiple);
			r = r + Power2Multiple.get(i).ratio;
			dividendL = dividendL - Power2Multiple.get(i).multiple;
		}
		
		if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) return Integer.MAX_VALUE;
		else return signR * (int) r;
		
    }
	
	public static void main(String[] args) {
		int dividend = -2147483648;
		int divisor = -1;
		System.out.println(divide(dividend, divisor));
	}
}
