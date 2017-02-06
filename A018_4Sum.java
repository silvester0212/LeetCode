import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.sun.prism.impl.Disposer.Target;

public class A018_4Sum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> r = new LinkedList<List<Integer>>();

		Arrays.sort(nums);
		
		for (int l = 0; l < nums.length - 3; l++) {
			if (l >= 1 && nums[l] == nums[l-1]) continue;
			if (4 * nums[l] > target) break;
			
			for (int i = l + 1; i < nums.length - 2; i++) {
				if (i >= l + 2 && nums[i] == nums[i-1]) continue;
				
				int new_target = target - nums[l] - nums[i];
				
				int j = i + 1;
				int k = nums.length - 1;

				while (j < k) {
					int curSum = nums[j] + nums[k];
					
					if (curSum == new_target) {
						List<Integer> newSolution = Arrays.asList(nums[l], nums[i], nums[j], nums[k]);

						r.add(newSolution);
						
						while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
						while (k > 0 && nums[k] == nums[k - 1]) k--;
						
						j++;
						k--;
					}
					else if (curSum < new_target) j++;
					else k--;
				}
			}
		}
		
		return r;
	}
	
	public static List<List<Integer>> fourSum_Naive(int[] nums, int target) {
		List<List<Integer>> r = new LinkedList<List<Integer>>();
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					for (int l = k + 1; l < nums.length; l++) {
						if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
							List<Integer> newSolution = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
							r.add(newSolution);
						}
					}
				}
			}
		}
		
		
		for (int i = 0; i < r.size(); i++) {
			List<Integer> List1 = r.get(i);
			
			for (int j = i + 1; j < r.size(); j++) {
				List<Integer> List2 = r.get(j);
				
				boolean match = true;
				
				for (int k = 0; k < List1.size(); k++) {
					if (match && List1.get(k) != List2.get(k)) match = false;
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
				1, 0, -1, 0, 2, -2
//				-4, -4, -3, -3, -2, -2, -1, -1, 0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4
//				-1, 0, 1, 2, -1, -4
		};
		int target = 0;
		
		System.out.println(printList(fourSum(nums, target)));
		
/*		while(true) {
			int[] nums = tools.getRandomIntArrays(50, 100);
			int target = 200;

			if(! fourSum(nums, target).equals(fourSum_Naive(nums, target))) {
				System.out.println(printList(fourSum(nums, target)));
				System.out.println(printList(fourSum_Naive(nums, target)));
				break;
			}
		}
*/		
	}
}
