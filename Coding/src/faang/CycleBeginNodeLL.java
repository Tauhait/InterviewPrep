package faang;

public class CycleBeginNodeLL {

/*
142. Linked List Cycle II
To understand this solution, you just need to ask yourself these question.
x1 = the distance from head to the start of the loop
x2 = the distance from the start of the loop to the point fast and slow meet
x3 = the distance from the point fast and slow meet to the start of the loop

 
What is the distance fast moved? 
=    x1 + x2 + x3 + x2 (since fast pointer moves twice the distance than slow pointer)
What is the distance slow moved?
=    x1 + x2
And their relationship?
=    x1 + x2 + x3 + x2 = 2 (x1 + x2)

Thus x1 = x3
*/
    public ListNode detectCycle(ListNode head) {
        ListNode cycleDetectNode = isCycle(head);
        if(cycleDetectNode == null) return null;
        while(head != cycleDetectNode) {
            head = head.next;
            cycleDetectNode = cycleDetectNode.next;
        }
        return head;
    }
    private ListNode isCycle(ListNode head){
        if(head == null || head.next == null) return null;        
        ListNode slow = new ListNode(Integer.MIN_VALUE);
        slow = head;
        ListNode fast = new ListNode(Integer.MIN_VALUE);
        fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return slow;
        }
        return null;
    }

}
