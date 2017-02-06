import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class A026_RemoveDuplicatesFromSortedArray {
	public static int removeDuplicates(int[] nums) {
		if (nums.length <= 1) return nums.length;
		
		int readPointer = 1;
		int writePointer = 1;
		
		while (readPointer < nums.length) {
			if (nums[readPointer] == nums[readPointer - 1]) {
				readPointer ++;
			}
			else {
				nums[writePointer] = nums[readPointer];
				writePointer++;
				readPointer++;
			}
		}
		return writePointer;
	}
	
	public static String removeDuplicates_Naive(int[] nums) {
		Arrays.sort(nums);
		StringBuilder output = new StringBuilder();
		
		for (int i = 0; i < nums.length; i++) {
			if ( i == 0 || (i > 0 && nums[i] != nums[i-1])) output.append(nums[i] + " ");
		}
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 2, 2, 3, 4, 5, 5, 5};
		System.out.println(tools.Array2Str(a));
		int[] b = a.clone();
		int length = removeDuplicates(a);
		
		StringBuilder StrF = new StringBuilder();
		for (int i = 0; i < length; i++) {
			StrF.append(a[i] + " ");
		}
		
		String StrN = removeDuplicates_Naive(b);
		
//		if (!StrN.equals(StrF.toString())) {
			System.out.println(tools.Array2Str(a));
			System.out.println("Fast  Method " + StrF.toString());
			System.out.println("Naive Method " + StrN);
//		}
		
/*		while (true) {
			int[] a = tools.getRandomIntArrays(Math.random() * 50, Math.random() * 25);
			Arrays.sort(a);
			int[] b = a.clone();
			int length = removeDuplicates(a);
			
			StringBuilder StrF = new StringBuilder();
			for (int i = 0; i < length; i++) {
				StrF.append(a[i] + " ");
			}
			
			String StrN = removeDuplicates_Naive(b);
			
			if (!StrN.equals(StrF.toString())) {
				System.out.println(a.toString());
				System.out.println("Fast  Method " + StrF.toString());
				System.out.println("Naive Method " + StrN);
				break;
			}
		}
*/	}
}
