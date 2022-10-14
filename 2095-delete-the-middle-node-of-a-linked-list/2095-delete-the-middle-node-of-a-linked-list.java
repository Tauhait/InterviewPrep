/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null)
            return null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prevToSlow = null;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            prevToSlow = slowPtr;
            slowPtr = slowPtr.next;
        }
        prevToSlow.next = prevToSlow.next.next;
        return head;
    }
}