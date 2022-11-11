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
    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode dummyHead = head;
        while(head != null){
            if(head.val == val){
                if(prev == null)//first node
                    dummyHead = dummyHead.next;
                else 
                    prev.next = head.next;
            }else {
                prev = head;
            }
            head = head.next;
        }
        return dummyHead;
    }
}