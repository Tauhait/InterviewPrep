package rest;

public class RemoveSpecificElemLL {
	public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        while(head != null && head.val == val) head = head.next;
        if(head != null) removeHelper(head, val);
        return head;
    }
    private void removeHelper(ListNode prev, int val) {
        ListNode curr = prev.next;
        while(curr != null) {
            if(curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
    }
}
