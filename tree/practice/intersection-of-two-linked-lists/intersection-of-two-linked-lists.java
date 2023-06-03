/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB) return headA;
        ListNode copyHeadA = headA;
        ListNode copyHeadB = headB;
        while(copyHeadA != copyHeadB){
            if(copyHeadA == null){
                copyHeadA = headB;
            } else {
                copyHeadA = copyHeadA.next;
            }
            if(copyHeadB == null){
                copyHeadB = headA;
            } else {
                copyHeadB = copyHeadB.next;
            }
        }
        return copyHeadA;
    }
}