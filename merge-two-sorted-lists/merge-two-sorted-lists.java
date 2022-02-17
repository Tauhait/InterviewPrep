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
    private void merge(ListNode l1, ListNode l2, ListNode result){
        if(l1 == null){
            result.next = l2;
            return;
        }
        if(l2 == null){
            result.next = l1;
            return;
        }
        ListNode newNode;
        if(l1.val > l2.val){
            //System.out.println(l1.val + " l1 > l2," + l2.val); 
            newNode = new ListNode(l2.val);
            result.next = newNode;
            result = result.next;
            merge(l1, l2.next, result);
        } else {
            //System.out.println(l1.val + " l1 < l2," + l2.val);
            newNode = new ListNode(l1.val);
            result.next = newNode;
            result = result.next;
            merge(l1.next, l2, result);  
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode dummyHead = new ListNode();
        merge(list1, list2, dummyHead);
        return dummyHead.next;
    }
}