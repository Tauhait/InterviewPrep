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
    private int index;
    private ListNode prev;
    private int capacity;
    private void helper(ListNode head, int n){
        if(head == null)
            return;
        capacity++;
        helper(head.next, n);
        index++;        
        if(index != n && index != n+1)
            prev = head;
        if(index == n+1)
            head.next = prev;
        
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        capacity = 0;
        index = 0;
        prev = null;
        helper(head, n);
        if(capacity == n)
            return head.next;
        return head;
    }
}