package rest;

public class GetDecimalValueFromLL {
	 public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	public int getDecimalValueIterative(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }
	public int getDecimalValueRecursive(ListNode head) { 
        if(head == null) return 0;
        if(head.next == null) return head.val;
        head.next.val += head.val << 1;
        return getDecimalValueRecursive(head.next);
    } 

}
