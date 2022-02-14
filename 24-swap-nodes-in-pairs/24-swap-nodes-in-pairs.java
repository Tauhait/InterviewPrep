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
/*
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
class Solution {
    public ListNode swapPairs(ListNode head) {

        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }
}
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1, head.next);
        if(head.next.next == null){
            head.next.next = head;
            head.next = null;
            return dummyHead.next;
        }        
        swap(head, null);
        return dummyHead.next;
    }
    private void swap(ListNode head, ListNode previous){
        if(head == null || head.next == null){
            return;
        }
        if(previous != null){
            previous.next = head.next;
        }
        previous = head;
        ListNode temp = head.next.next;
        head.next.next = head;
        head.next = temp;
        swap(temp, previous);
    }
}