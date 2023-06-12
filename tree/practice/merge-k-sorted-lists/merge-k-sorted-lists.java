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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        int interval = 1;
        while(interval < n){
            for(int j = 0; j < n-interval; j += interval*2){
                lists[j] = mergeTwoLists(lists[j], lists[j+interval]);
            }
            interval *= 2;
        }
        return n > 0 ? lists[0] : null;
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = new ListNode(l1.val,null);
                l1 = l1.next;
            }else {
                tail.next = new ListNode(l2.val,null);
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}