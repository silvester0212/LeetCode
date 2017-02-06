public class A019_RemoveNthNodeFromEndOfList {

	public static ListNode removeNthFromEnd_Naive(ListNode head, int n) {
		ListNode pointer = head;
		int listLength = 0;
		
		while (pointer != null) {
			listLength ++;
			pointer = pointer.next;
		}
//		System.out.println(listLength);
		
		int nodesBeforeTarget = listLength - n;
		
		if (nodesBeforeTarget == 0) return head.next;
		
		int nodeTraveled = 1;
		pointer = head;
		while (nodeTraveled < nodesBeforeTarget) {
			pointer = pointer.next;
			nodeTraveled ++;
		}
		
//		System.out.println(pointer.val);
		
		pointer.next = pointer.next.next;
		
		return head;
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) return null;
		
		ListNode p1 = head;
		ListNode p2 = head;
		int cnt = 0;
		while (p1.next != null && cnt < n) {
			p1 = p1.next;
			cnt ++;
		}
		
		if (cnt == n - 1) return head.next;
		else if (cnt != n) {
			System.out.println("First Pointer Value " + p1.val + "\nCounter Value " + cnt);
			System.exit(0);
		}
		
		while(p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		p2.next = p2.next.next;
		
		return head;
	}
	
	public static void main(String[] args) {
//		int[] nums = new int[] { 7, 6, 5, 4, 3, 2, 1};
		int iteration = 0;
		
		while (true) {
			iteration ++;
			System.out.println("Iteration " + iteration);
			int[] nums = tools.getRandomIntArrays(1000, 10);
			int n = 1+ (int) (Math.random() * 900);
			
			ListNode rn = removeNthFromEnd_Naive(new ListNode(nums), n);
			ListNode rf = removeNthFromEnd(new ListNode(nums), n);
			if (! rn.toString().equals(rf.toString())) {
				System.out.println("Fast  Method " + rf.toString());
				System.out.println("Naive Method " + rn.toString());
				break;
			}
		}
	}
}
