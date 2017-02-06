
public class A002_AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) { val = x; }
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Do the first iteration;
		int n1 = l1.val;
//		System.out.println("List 1 current element " + n1);
		int n2 = l2.val;
//		System.out.println("List 2 current element " + n2);
		int sum = n1 + n2;
		ListNode Sum = new ListNode(sum % 10);
		int carry = sum / 10;
		
		ListNode dynamicSum = Sum;
		ListNode dynamicL1 = l1;
		ListNode dynamicL2 = l2;
		
		while (dynamicL1.next != null && dynamicL2.next != null) {
			dynamicL1 = dynamicL1.next;
			dynamicL2 = dynamicL2.next;
			
			n1 = dynamicL1.val;
//			System.out.println("List 1 current element " + n1);
			n2 = dynamicL2.val;
//			System.out.println("List 2 current element " + n2);
			sum = n1 + n2 + carry;
			carry = sum / 10;
			dynamicSum.next = new ListNode(sum % 10);
			dynamicSum = dynamicSum.next;
		}
		
		ListNode left = null;
		if (dynamicL1.next == null && dynamicL2.next == null) left = null;
		else if (dynamicL1.next == null) left = dynamicL2.next;
		else left = dynamicL1.next;
		
		while(left != null) {
			sum = left.val + carry;
			carry = sum / 10;
			dynamicSum.next = new ListNode(sum % 10);
			left = left.next;
			dynamicSum = dynamicSum.next;
		}
		
		if (carry != 0) dynamicSum.next = new ListNode(carry);
		
		return Sum;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
//		l1.next = new ListNode(4);
//		ListNode dynamicL1 = l1.next;
//		dynamicL1.next = new ListNode(3);
//		dynamicL1 = dynamicL1.next;
//		dynamicL1.next = new ListNode(0);

		ListNode l2 = new ListNode(8);
		l2.next = new ListNode(9);
//		ListNode dynamicL2 = l2.next;
//		dynamicL2.next = new ListNode(4);

		ListNode sum = addTwoNumbers(l1, l2);
		
		System.out.println(List2Str(sum));
	}
	
	public static String List2Str(ListNode input) {
		StringBuilder output = new StringBuilder();
		
		while (true) {
			output.append(input.val);
			
			if (input.next != null) {
				output.append(", ");
				input = input.next;
			}
			else break;
		}
		
		return output.toString();
	}
}
