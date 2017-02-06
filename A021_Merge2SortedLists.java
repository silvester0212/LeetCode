import java.util.Arrays;

public class A021_Merge2SortedLists {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode output = new ListNode(0);
		ListNode pointer = output;
		int iteration = 0;
		
		while (l1 != null || l2 != null) {
			iteration ++;
//			System.out.print("Iteration " + iteration);
			
			if (l1 == null && l2 != null) {
//				System.out.println(" entering Condition 1...");
				pointer.next = new ListNode(l2.val);
				l2 = l2.next;
				pointer = pointer.next;
			}
			else if (l1 != null && l2 == null) {
//				System.out.println(" entering Condition 2...");
				pointer.next = new ListNode(l1.val);
				l1 = l1.next;
				pointer = pointer.next;
			}
			else {
				int v1 = l1.val;
				int v2 = l2.val;
				
				if (v1 < v2) {
//					System.out.println(" entering Condition 3...");
					pointer.next = new ListNode(v1);
					pointer = pointer.next;
					l1 = l1.next;
				}
				else {
//					System.out.println(" entering Condition 4...");
					pointer.next = new ListNode(v2);
					pointer = pointer.next;
					l2 = l2.next;
				}
			}
			
		}
		
//		System.out.println(l1.toString());
//		System.out.println(l2.toString());
		
		return output.next;
	}
	
	public static ListNode mergeTwoLists_Naive(int[] a1, int[] a2) {
		int[] ar = new int[a1.length + a2.length];
		
		for (int i = 0; i < a1.length; i++) ar[i] = a1[i];
		for (int j = 0; j < a2.length; j++) ar[a1.length + j] = a2[j];
		
		Arrays.sort(ar);
		
		return new ListNode(ar);
	}
	
	public static void main(String[] args) {
//		int[] a1 = new int[]{1, 3, 5, 7, 9, 11};
		int[] a1 = new int[0];
		int[] a2 = new int[]{2, 4, 6, 8, 10};
		
		ListNode l1 = new ListNode(a1);
		ListNode l2 = new ListNode(a2);
		
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		System.out.println(mergeTwoLists(l1, l2).toString());
//		System.out.println(mergeTwoLists_Naive(a1, a2));

		int iteration = 0;
		
/*		while (true) {
			iteration ++;
			System.out.print("Iteration " + iteration );
			int[] a1 = tools.getRandomIntArrays(Math.random() * 100, Math.random() * Integer.MAX_VALUE);
			int[] a2 = tools.getRandomIntArrays(Math.random() * 100, Math.random() * Integer.MAX_VALUE);
			Arrays.sort(a1);
			Arrays.sort(a2);
			
			ListNode rf = mergeTwoLists(new ListNode(a1), new ListNode(a2));
			ListNode rn = mergeTwoLists_Naive(a1, a2);
			if (! rf.toString().equals(rn.toString())) {
				System.out.println("List 1 " + a1.toString());
				System.out.println("List 2 " + a1.toString());
				System.out.println("Fast  Method " + rf.toString());
				System.out.println("Naive Method " + rn.toString());
				break;
			}
			
			System.out.println(" matched!");
		}
*/
	}
}
