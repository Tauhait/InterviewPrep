package faang;

public class DetectCycleLL {
	//Naive approach: Use hashing to store node addresses and keep checking everytime. TC - O(n) SC - O(n)
    //Optimal approach: Use slow-fast pointer approach. At some point they are going to meet. TC - O(n) SC - O(1)
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
