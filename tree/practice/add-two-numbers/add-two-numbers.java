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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode added = new ListNode(-1);
        ListNode head = added;
        while(l1 != null && l2 != null){
            int sum = carry + l1.val + l2.val;
            if(sum > 9) carry = 1;
            else carry = 0;
            head.next = new ListNode(sum%10);
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }
        while(l1 != null){
            int sum = carry + l1.val;
            if(sum > 9) carry = 1;
            else carry = 0;            
            head.next = new ListNode(sum%10);
            l1 = l1.next;
            head = head.next;
        }
        while(l2 != null){
            int sum = carry + l2.val;
            if(sum > 9) carry = 1;
            else carry = 0;            
            head.next = new ListNode(sum%10);
            l2 = l2.next;
            head = head.next;
        }
        if(carry > 0) head.next = new ListNode(carry);
        return added.next;
    }
}