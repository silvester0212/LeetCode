
public class A024_SwapNodesInPairs {
	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		else {
			ListNode firstNode = head;
			ListNode secondNode = head.next;
			ListNode lastNode = swapPairs(head.next.next);
			
			secondNode.next = firstNode;
			firstNode.next = lastNode;
			
			return secondNode;
		}
	}
	
	public static ListNode swapPairs(int[] a) {
		for (int i = 0; i < a.length - 1; i += 2) {
			int temp = a[i];
			a[i] = a[i + 1];
			a[i + 1] = temp;
		}
		
		return new ListNode(a);
	}
	
	public static void main(String[] args) {
/*		int[] a1 = new int[]{1, 2, 3, 4, 5, 6};
		
		ListNode input = new ListNode(a1);
		System.out.println(input.toString());
		ListNode outputF = swapPairs(input);
		System.out.println(outputF.toString());
		ListNode outputN = swapPairs(a1);
		System.out.println(outputN.toString());
*/
		
		while (true) {
			int[] a = tools.getRandomIntArrays(Math.random() * 1000, Math.random() * 100);
			
			ListNode input = new ListNode(a);
			ListNode outputF = swapPairs(input);
			ListNode outputN = swapPairs(a);
			
			if (! outputF.toString().equals(outputN.toString())) {
				System.out.println("Input " + input.toString());
				System.out.println("Fast  Method " + outputF.toString());
				System.out.println("Naive Method " + outputN.toString());
				break;
			}
		}
	}
}
