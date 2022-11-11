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
    public ListNode reverseList(ListNode head) {//5>4>3>2>1
        ListNode prev = null;
        ListNode start = head;
        while(start != null){
            ListNode nextNode = start.next;
            start.next = prev;
            prev = start;
            start = nextNode;
        }
        return prev;
    }
}