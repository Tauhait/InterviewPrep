package faang;

public class ReverseLL2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || n - m + 1 <= 1) return head;        
        int len = n - m + 1;
        ListNode prev = new ListNode();
        ListNode start = new ListNode();
        ListNode end = new ListNode();
        prev = traverse(head, m - 2);
        start = prev == null ? head : prev.next;
        end = traverse(start, len);
        if(prev != null) prev.next = reverseList(start, end);
        else head = reverseList(start, end);
        return head;
    }
    private ListNode traverse(ListNode head, int iter){
        if(iter < 0) return null;
        while(--iter >= 0 && head != null) head = head.next;
        return head;
    }
    private ListNode reverseList(ListNode start, ListNode end){
		 if(start == null) return null;
		 ListNode dummyHead = end;
		 while(start != end){
		     ListNode next = start.next;
		     start.next = dummyHead;
		     dummyHead = start;
		     start = next;
		 }
         return dummyHead;
	}
}
