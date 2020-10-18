package faang;

public class RemoveNthNodeFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode result = new ListNode();
        result.next = head;
        while(n-- > 0) fast = fast.next;
        if(fast == null) return slow.next;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return result.next;
    }
}
