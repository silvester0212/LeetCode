import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.sun.prism.impl.Disposer.Target;

public class A015_3Sum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> r = new LinkedList<List<Integer>>();

		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length - 2; i++) {
			if (i >= 1 && nums[i] == nums[i-1]) continue;
			
			int target = - nums[i];
			
			int j = i + 1;
			int k = nums.length - 1;

			while (j < k) {
				int curSum = nums[j] + nums[k];
				
				if (curSum == target) {
					List<Integer> newSolution = new LinkedList<Integer>();
					newSolution.add(nums[i]);
					newSolution.add(nums[j]);
					newSolution.add(nums[k]);
					r.add(newSolution);
					
					while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
					while (k > 0 && nums[k] == nums[k - 1]) k--;
					
					j++;
					k--;
				}
				else if (curSum < target) j++;
				else k--;
			}
		}
		
		return r;
	}
	
	public static List<List<Integer>> threeSum_Naive(int[] nums) {
		List<List<Integer>> r = new LinkedList<List<Integer>>();
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> newSolution = new LinkedList<Integer>();
						newSolution.add(nums[i]);
						newSolution.add(nums[j]);
						newSolution.add(nums[k]);
						r.add(newSolution);
					}
				}
			}
		}
		
		
		for (int i = 0; i < r.size(); i++) {
			List<Integer> curList = r.get(i);
			
			for (int j = i + 1; j < r.size(); j++) {
				List<Integer> nextList = r.get(j);
				
				boolean match = true;
				
				for (int k = 0; k < curList.size(); k++) {
					if (match && curList.get(k) != nextList.get(k)) match = false;
				}
				
				if (match) {
					r.remove(j);
					j--;
				}
			}
			
		}
		
		return r;
	}
	
	public static String printList(List<List<Integer>> r) {
		StringBuilder output = new StringBuilder();
		
		output.append("[\n");
		
		for (int i = 0; i < r.size(); i++) {
			List<Integer> innerList = r.get(i);
			output.append("\t[");
			for (int j = 0; j < innerList.size(); j++) {
				output.append(innerList.get(j));
				
				if (j != innerList.size() - 1) output.append(", ");
			}
			output.append("]");
			if (i != r.size() - 1) output.append(',');
			output.append("\n");
		}
		
		output.append("]\n");
		
		return output.toString();
	}
	
	public static void main(String[] args) {
		
		int[] nums = new int[] {
//				-1, 1
				-4, -4, -3, -3, -2, -2, -1, -1, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4
//				-1, 0, 1, 2, -1, -4
		};
		
		System.out.println(printList(threeSum(nums)));
		System.out.println(printList(threeSum_Naive(nums)));
	}
}
