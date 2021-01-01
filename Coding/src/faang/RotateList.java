package faang;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        
        int len = 1;
        ListNode cur = head;
        while(cur.next != null) {
            len++;
            cur = cur.next;
        }
        k = k % len;
        k = len - k;
        cur.next = head;
        
        while(k-- > 0) cur = cur.next;
        
        head = cur.next;
        cur.next = null;
        return head;
    }
}
