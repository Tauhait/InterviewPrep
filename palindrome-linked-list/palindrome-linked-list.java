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
    public boolean isPalindrome(ListNode head) {
        int size = 0;
        ListNode listItr = head;
        while(listItr != null){
            listItr = listItr.next;
            ++size;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if(size % 2 == 1) slow = slow.next;
        while(slow != null && prev != null){
            if(slow.val != prev.val) return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}