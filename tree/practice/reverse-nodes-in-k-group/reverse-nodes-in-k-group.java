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
    private List<ListNode> reverseLL(ListNode prev, ListNode head, int k){
        if(k == 0 || head == null) {
            List<ListNode> prevCurr = new ArrayList<>();
            prevCurr.add(prev);
            prevCurr.add(head);
            return prevCurr;
        }
        ListNode nextNode = head.next;
        head.next = prev;
        List<ListNode> node = reverseLL(head, nextNode, k-1);
        return node;
    }
    private int findLen(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 0) return head;
        ListNode copyHead = head;
        ListNode newHead = null;
        int len = findLen(head);
        int multiplier = len/k;
        ListNode prev = null;
        while(multiplier-- > 0){ 
            List<ListNode> revHead = reverseLL(null, copyHead, k);
            if(prev != null) prev.next = revHead.get(0);
            prev = copyHead;
            copyHead = revHead.get(1);
            if(newHead == null) newHead = revHead.get(0);
        }
        prev.next = copyHead;
        return newHead;
    }
}