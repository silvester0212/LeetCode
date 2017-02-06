import java.util.Arrays;

public class A001_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
/*		//Naive Implementation
   		for (int i = 0; i < nums.length; i++) {
    		for (int j = i+1; j < nums.length; j++) {
    			if (nums[i] + nums[j] == target) {
    				int[] results = {i, j};
    				return results;
    			}
    		}
    	}
*/
    	
    	// Use QuickSort
      	int[] sorted = (int[]) nums.clone();
      	Arrays.sort(sorted);
 //   	System.out.println(Array2Str(sorted));

    	int bgnIdx = 0;
    	int endIdx = sorted.length - 1;
    	int iterationIdx = 0;
    	int iterationMax = sorted.length * (sorted.length - 1) / 2;
    	
    	do {
    		iterationIdx ++;
    		
    		int num1 = sorted[bgnIdx];
    		int num2 = sorted[endIdx];
    		
    		int sum = num1 + num2;
    		if (sum == target) break;
    		else if (sum < target) bgnIdx++;
    		else if (sum > target) endIdx--;
    	} while (iterationIdx <= iterationMax);
    	
    	if (iterationIdx > iterationMax) return null;
    	else {
    		int Idx1 = -1;
    		int Idx2 = -1;
    		
    		int pointerIdx = -1;
    		do {
    			pointerIdx++;
   				if (Idx1 == -1 && nums[pointerIdx] == sorted[bgnIdx]) {
   					Idx1 = pointerIdx;
   					continue;
   				}
   				if (Idx2 == -1 && nums[pointerIdx] == sorted[endIdx]) Idx2 = pointerIdx;
    		} while (Idx1 == -1 || Idx2 == -1);
    		
    		return new int[] {Math.min(Idx1, Idx2), Math.max(Idx1, Idx2)};
    	}
    }
    
    public static void main(String[] args) {
    	int[] nums = {3, 2, 6};
    	int target = 8;
    	
    	int[] results = twoSum(nums, target);
    	
    	if (results == null) System.out.println("No pairs found");
    	else System.out.println(Array2Str(results));
	}
    
    public static String Array2Str(int[] input) {
    	StringBuilder output = new StringBuilder();
    	
    	for (int i = 0; i < input.length; i++) {
    		output.append(input[i]);
    		
    		if (i != input.length - 1) output.append(", ");
    	}
    	
    	return output.toString();
    }
}
