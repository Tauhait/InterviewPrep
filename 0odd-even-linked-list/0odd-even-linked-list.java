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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode oddRunner = new ListNode(head.val);
        ListNode evenRunner = new ListNode(head.next.val);
        ListNode headOdd = oddRunner;
        ListNode headEven = evenRunner;
        boolean oddNo = true;
        head = head.next.next;
        while(head != null){
            if(oddNo){
                oddRunner.next = new ListNode(head.val);
                oddRunner = oddRunner.next;
                oddNo = false;
            }else {
                evenRunner.next = new ListNode(head.val);
                evenRunner = evenRunner.next;
                oddNo = true;
            }
            head = head.next;
        }
        oddRunner.next = headEven;
        return headOdd;    
    }
}