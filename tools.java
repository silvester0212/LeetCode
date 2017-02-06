public class tools {
	public static int[] getRandomIntArrays(int ElementCnt, int maxElement) {
		int[] r = new int[ElementCnt];
		for(int i = 0; i < ElementCnt; i++) {
			r[i] = getRandomInt(maxElement);
		}
		
		return r;
	}
	
	public static int getRandomInt(int maxInt) {
		return (int) (Math.random() * maxInt);
	}

	
	public static void main(String[] args) {
		System.out.println("Compile succeeded.");
	}

	public static int[] getRandomIntArrays(double ElementCnt, double maxElement) {
		int intElementCnt = (int) ElementCnt + 1;
		int intMaxElement = (int) maxElement;
		return getRandomIntArrays(intElementCnt, intMaxElement);
	}
	
	public static String Array2Str(int[] a) {
		StringBuilder output = new StringBuilder();
		
		output.append('[');
		for (int i = 0; i < a.length; i++) {
			output.append(a[i]);
			
			if (i != a.length - 1) output.append(", ");
		}
		output.append(']');
		
		return output.toString();
	}
	
	public static String PartialArray2Str(int[] a, int printLength) {
		StringBuilder output = new StringBuilder();
		
		output.append('[');
		for (int i = 0; i < printLength; i++) {
			output.append(a[i]);
			
			if (i != printLength - 1) output.append(", ");
		}
		output.append(']');
		
		return output.toString();
	}
}
