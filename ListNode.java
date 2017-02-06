public class ListNode {
	int val;
	ListNode next;
		
	public ListNode(int x) { 
		val = x; 
	}

	public String toString() {
		if (this == null) return "";
	
		StringBuilder output = new StringBuilder();
		
		ListNode pointer = this;
		while(pointer.next != null) {
			output.append(pointer.val + "->");
			pointer = pointer.next;
		}
		
		output.append(pointer.val);
		
		return output.toString();
	}
		
	public ListNode(int[] a) {
		if (a.length == 0) return;
		
		ListNode head = new ListNode(a[0]);
		ListNode pointer = head;
		
		for(int i = 1; i < a.length; i++) {
			pointer.next = new ListNode(a[i]);
			pointer = pointer.next;
		}
		
		this.val = head.val;
		this.next = head.next;
	}
}
