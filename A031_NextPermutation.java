import java.util.ArrayList;
import java.util.Collection;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class A031_NextPermutation {
	public static void nextPermutation(int[] nums) {
//		System.out.println(tools.Array2Str(nums));
		
		int suffixBgnPointer = nums.length - 1;
		while(suffixBgnPointer > 0 && nums[suffixBgnPointer] <= nums[suffixBgnPointer - 1]) suffixBgnPointer--;
//		System.out.println(suffixBgnPointer);
		
		if (suffixBgnPointer > 0) {
			int swapToPointer = nums.length - 1;
			
			for (; swapToPointer > suffixBgnPointer; swapToPointer --) {
				if (nums[swapToPointer] > nums[suffixBgnPointer - 1]) break;
			}
//			System.out.println(swapToPointer);
			
			int temp = nums[suffixBgnPointer - 1];
			nums[suffixBgnPointer - 1] = nums[swapToPointer];
			nums[swapToPointer] = temp;
			
//			System.out.println(tools.Array2Str(nums));
		}
		
		int endPointer = nums.length - 1;
		while (suffixBgnPointer < endPointer) {
			int temp = nums[suffixBgnPointer];
			nums[suffixBgnPointer] = nums[endPointer];
			nums[endPointer] = temp;
			suffixBgnPointer ++;
			endPointer --;
		}
		
//		System.out.println(tools.Array2Str(nums));
	}
	
	public static void nextPermutation_Naive(int[] nums) {
		ArrayList<Integer> numList = new ArrayList<Integer>(nums.length);
		for (int i = 0; i < nums.length; i++) numList.add(nums[i]);
		
//		Collections.next
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {
				
		};
		
		nextPermutation(nums);
	}
}
