import javax.print.DocFlavor.INPUT_STREAM;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

public class A011_MaxArea {
	public static int maxArea(int[] height) {
		if (height == null || height.length <= 1) return 0;
		
		int maxArea = 0;
		int left = 0;
		int right = height.length - 1;
		while (left < right) {
			int area = Math.min(height[left], height[right]) * (right - left);
			if (area > maxArea) maxArea = area;

			if (height[left] < height[right]) {
				left ++;
			}
			else {
				right --;
			}
			
			/* Proof of safe move
			Use v[low, high] indicates the volume of container with low and high. 
			Suppose height[low] < height[high], then we move low to low+1, 
			that means we ingored v[low, high-1],v[low, high-2],etc. 
			If this is safe, then the algorithm is right. 
			It's safe because v[low, high-1],high[low, high-2]...... can't be larger than v[low, high] 
			since its width can't be larger than high-low, and its height is limited by height[low].
			*/

		}		
		return maxArea;
	}
	
	public static int maxArea_Naive(int[] height) {
		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i+1; j < height.length; j++) {
				int area = Math.min(height[i], height[j]) * (j-i);
				
				if (maxArea < area) maxArea = area;
			}
		}
		
		return maxArea;
	}
	
	public static void stressTest() {
		boolean match = true;
		int method = 0;
		int naive = 0;
		int iteration = 0;
		int[] height = null;
		
		while (match) {
			System.out.println("Iteration " + iteration + " matched!");
			iteration ++;
			
			int elements = (int) (Math.random() * 50);
			
			height = new int[elements];
			
			for (int i = 0; i < elements; i++) {
				height[i] = (int) (Math.random() * 20);
			}
			
			method = maxArea(height);
			naive = maxArea_Naive(height);
			
			match = (method == naive);
		}
		
		System.out.println("Unmatch found with Array " + Array2Str(height));
		System.out.println("Method " + method + "\nNaive " + naive);
	}
	
	public static void main(String[] args) {
		stressTest();
	}
	
	public static int max (int... x) {
		int r = x[0];
		
		for (int i = 1; i < x.length; i++) {
			if (x[i] > r) r = x[i];
		}
		
		return r;
	}
	
	public static String Array2Str(int[] x) {
		StringBuilder output = new StringBuilder();
		output.append('[');
		
		for (int i = 0; i < x.length; i++) {
			output.append(x[i]);
			
			if (i != x.length - 1) output.append(", ");
			else output.append("]\n");
		}
		
		return output.toString();
	}
}
