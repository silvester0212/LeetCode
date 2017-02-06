import sun.net.www.content.audio.x_aiff;

public class A009_PalindromeNum {	
	public static boolean isPalindrome(int x) {
		if (x < 0) return false;
		
		int significance = (int) Math.log10(x);
		
		int midPoint = significance / 2;
		
			int i = 0;
			while (significance - i >= midPoint && i <= midPoint && significance - i >= i) {
				int left = (int) ((x / Math.pow(10, significance - i)) % 10) ;
				int right = (int) ((x / Math.pow(10, i)) % 10);
				
//				System.out.println("Iteration Loop: " + (i + 1) + " comparing " + left + " and " + right);
				if (left != right) return false;
				
				i++;
			}
		
		return true;
	}
	
	public static void main(String[] args) {
		int x = 1331;
		System.out.println(isPalindrome(x));
	}
}
