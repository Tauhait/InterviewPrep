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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode merged = new ListNode(-101);
        ListNode newHead = merged;
        while(list1 != null && list2 != null){
            ListNode newNode;
            if(list1.val < list2.val){
                newNode = new ListNode(list1.val);
                newHead.next = newNode;
                list1 = list1.next;
            } else {
                newNode = new ListNode(list2.val);
                newHead.next = newNode;
                list2 = list2.next;
            }
            newHead = newHead.next;
        }

        while(list1 != null){
            newHead.next = new ListNode(list1.val);
            list1 = list1.next;
            newHead = newHead.next;
        }
        while(list2 != null){
            newHead.next = new ListNode(list2.val);
            list2 = list2.next;
            newHead = newHead.next;
        }
        return merged.next;
    }
}