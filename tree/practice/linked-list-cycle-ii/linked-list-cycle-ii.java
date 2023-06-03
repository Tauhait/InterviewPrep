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
        if(head == null || head.next == null) return null;
        if(head.next == head) return head;
        ListNode copyHead = head;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                while(copyHead != slow){
                    slow = slow.next;
                    copyHead = copyHead.next;
                }
                return slow;
            }
        }
        return null;        
    }
}