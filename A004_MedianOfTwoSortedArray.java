import java.util.ArrayList;

public class A004_MedianOfTwoSortedArray {
	public static double findMedianSortedArraysODD(int[] nums1, int[] nums2) {
		int p1 = 0;
		int p2 = 0;
		
		System.out.println("Program begins...");
		System.out.println("List 1\t" + Array2Str(nums1, p1));
		System.out.println("List 2\t" + Array2Str(nums2, p2) + "\n");
		
		ArrayList<Integer> lc = new ArrayList<Integer>();
		int med1 = 0;
		int med2 = 0;
		
		boolean oddList = ((nums1.length + nums2.length) % 2 == 1);
		double posMedian = (nums1.length + nums2.length) / 2.0;
		int numsRead = 0;
		
		while (numsRead < posMedian + 1) {
			numsRead ++;
			
			int n1 = 0, n2 = 0;
			int min = 0;
			
			boolean l1Empty = (nums1.length == p1);
			boolean l2Empty = (nums2.length == p2);
			
			if (! l1Empty) n1 = nums1[p1];
			if (! l2Empty) n2 = nums2[p2];
			
			if (! l1Empty && ! l2Empty) {
				if (n1 < n2) {
					lc.add(n1);
					min = n1;
					p1 ++;
				}
				else {
					lc.add(n2);
					min = n2;
					p2 ++;
				}
			}
			else if (l1Empty) {
				lc.add(n2);
				min = n2;
				p2 ++;
			}
			else {
				lc.add(n1);
				min = n1;
				p1 ++;
			}
			
			if (numsRead >= posMedian - 1 && numsRead < posMedian) {
				med1 = min;
			}
			else if (numsRead >= posMedian && numsRead < posMedian + 1) {
				med2 = min;
			}

			
			System.out.println("Iteration " + (numsRead) + "...");
			System.out.println("List 1\t" + Array2Str(nums1, p1));
			System.out.println("List 2\t" + Array2Str(nums2, p2));
			System.out.println("List R\t" + List2Str(lc) + "\n");
		}
		
		return med1;
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int p1 = 0;
		int p2 = 0;
		
		System.out.println("Program begins...");
		System.out.println("List 1\t" + Array2Str(nums1, p1));
		System.out.println("List 2\t" + Array2Str(nums2, p2) + "\n");
		
		ArrayList<Integer> lc = new ArrayList<Integer>();
		int med1 = 0;
		int med2 = 0;
		
		boolean oddList = ((nums1.length + nums2.length) % 2 == 1);
		
		if (oddList) return findMedianSortedArraysODD(nums1, nums2);
		else return findMedianSortedArraysODD(nums1, nums2);
    }
	
	public static void main(String[] args) {
		int[] nums1 = {3,5};
		int[] nums2 = {2,4,6};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
	
	public static ArrayList<Integer> Array2List(int[] input) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		for (int i = 0; i < input.length; i++) {
			output.add(input[i]);
		}
		
		return output;
	}
	
	public static String Array2Str(int[] input, int index) {
		StringBuilder output = new StringBuilder();
		
		for (int i = index; i < input.length; i++) {
			output.append(input[i]);
			
			if (i != input.length - 1) output.append(", ");
		}
		
		return output.toString();
	}
	
	public static String List2Str(ArrayList<Integer> input) {
		StringBuilder output = new StringBuilder();
		
		for (int i = 0; i < input.size(); i++) {
			output.append(input.get(i));
			
			if (i != input.size() - 1) output.append(", ");
		}
		
		return output.toString();
	}
}
