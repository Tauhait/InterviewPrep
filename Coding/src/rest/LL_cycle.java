package rest;

public class LL_cycle {
	class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) {
			 val = x;
			 next = null;
		 }
	}
	public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return null;
        if(head.next == head || head.next.next == head || head.next.next == head.next)
            return head;
        
        while(head != null && head.val != Integer.MIN_VALUE){
            head.val = Integer.MIN_VALUE;
            head = head.next;
        }
        return head;                    
    }
}
