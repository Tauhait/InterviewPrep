/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        do {
            if(fast == null || fast.next == null)
                break;
            fast = fast.next.next;
            slow = slow.next;
        } while(fast != slow);
        if(fast == slow){
            ListNode start = head;
            while(start != slow){
                start = start.next;
                slow = slow.next;
            }
            return start;
        }
        return null;
    }
}