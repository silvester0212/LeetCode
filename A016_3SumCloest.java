import java.util.Arrays;

public class A016_3SumCloest {
	public static int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return nums[0] + nums[1];
		if (nums.length == 3) return nums[0] + nums[1] + nums[2];
		
		Arrays.sort(nums);
		
		int r = nums[0] + nums[1] + nums[2];
		int absDiff = Math.abs(r - target);
		
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			
			while (j < k) {
				int curSum = nums[i] + nums[j] + nums[k];
				
				if (curSum == target) return curSum;
				else if (curSum < target) j++;
				else k--;
				
				if (Math.abs(curSum - target) < absDiff) {
					absDiff = Math.abs(curSum - target);
					r = curSum;
				}
			}
		}
		
		return r;
	}
	
	public static int threeSumClosest_Naive(int[] nums, int target) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return nums[0] + nums[1];
		if (nums.length == 3) return nums[0] + nums[1] + nums[2];
		
		Arrays.sort(nums);
		
		int r = nums[0] + nums[1] + nums[2];
		int absDiff = Math.abs(r - target);
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int curSum = nums[i] + nums[j] + nums[k];
					
					if (curSum == target) return curSum;
					
					if (Math.abs(curSum - target) < absDiff) {
						absDiff = Math.abs(curSum - target);
						r = curSum;
					}
				}
			}
		}
		
		return r;
	}
	
	public static void main(String[] args) {
/*		int[] nums = new int[] {
				-1, 2, 1, 4
		};
		int target = 1;
*/
		while (true) {
			int[] nums = tools.getRandomIntArrays(50, 100);
			int target = tools.getRandomInt(5000);
			
			int m1 = threeSumClosest(nums, target);
			int mn = threeSumClosest_Naive(nums, target);
			
			if (m1 != mn && m1 + mn != 2 * target) {
				System.out.println("Not Matched");
				System.out.println("Nums " + nums);
				System.out.println("Target " + target);
				System.out.println("Ans1 " + m1);
				System.out.println("Ans2 " + mn);
			}
		}
	}
}
