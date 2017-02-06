import java.util.Arrays;

public class A027_RemoveElement {
	public static int removeElement_M1(int[] nums, int val) {
		Arrays.sort(nums);
		if (nums == null) return 0;
		if (val < nums[0] || val > nums[nums.length - 1]) return nums.length;
		
		int readPointer = 0;
		while (readPointer < nums.length && nums[readPointer] < val) readPointer++;
		int writePointer = readPointer;
		
		while (readPointer < nums.length && nums[readPointer] == val) readPointer++;
		
		while (readPointer < nums.length) {
			nums[writePointer] = nums[readPointer];
			writePointer++;
			readPointer++;
		}
		
		return writePointer;
	}
	
	public static int removeElement(int[] nums, int val) {
		if (nums == null) return 0;
		int writePointer = 0;
		
		for (int readPointer = 0; readPointer < nums.length; readPointer ++) {
			if (nums[readPointer] != val) {
				nums[writePointer] = nums[readPointer];
				writePointer ++;
			}
		}
		
		return writePointer;
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3, 4, 6, 1, 2, 3, 4, 6, 1, 3, 6};
		int val = 4;
		
		int length = removeElement(a, val);
		System.out.println(tools.PartialArray2Str(a, length));
	}
}
