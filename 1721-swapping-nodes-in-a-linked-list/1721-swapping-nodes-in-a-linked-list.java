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
    
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null){
            return head;
        }
        ListNode frontK = new ListNode(-1);
        ListNode endK = new ListNode(-1);
        int len = getLen(frontK, head, k);
        int end = len - k + 1;
        // System.out.println(len + " " + end);
        // System.out.println(frontK.next.val + " " + frontK.val);
        getEndK(endK, head, end);
        frontK.next.val = endK.val;
        endK.next.val = frontK.val;
        return head;        
    }
    private int getLen(ListNode frontK, ListNode head, int k){
        int index = 1;
        int len = 0;
        while(head != null){
            if(index == k){
                frontK.val = head.val;
                frontK.next = head;
            }
            head = head.next;
            index++;
            len++;
        }
        return len;
    }
    private void getEndK(ListNode endK, ListNode head, int end){
        int index = 1;
        while(head != null){
            if(index == end){
                endK.val = head.val;
                endK.next = head;
                break;
            }
            head = head.next;
            index++;            
        }
    }
    
}