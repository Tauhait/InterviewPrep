package faang;

import java.util.Stack;

public class IntersectionOfTwoSingleLL {
	//Brute-force approach: For every node in the first linkedlist traverse all the nodes in the second linkedlist TC - O(N*N)
    //Better approach: Store node addressess in a hash table for one linkedlist and then check for same node address by traversing the other linkedlist. TC - O(N + M) SC - O(N)
    //Optimal Approach 1: TC - O(N) SC - O(1)
        //1. At first traverse both the linkedlists simultaneously using two dummy heads and also get the count of the lengths of each of the linkedlists.
        //2. Calc the diff in the lengths
        //3. Reset the dummy heads
        //4. Advance the shorter linkedlist by the diff
        //5. Traverse both dummy heads simultaneously 
        //6. Return the collision point or -1 if they don't collide
    //Optimal Approach 2: TC - O(N) SC - O(1)
        //1. At first traverse both the linkedlists simultaneously until any one of them reaches the end.
        //2. When one dummy head reaches end, assign that dummy head the address of the head of other linkedlist(which it was not traversing).
        //3. Keep traversing simultaneously until the again dummy head(one which didn't reach the end) reaches the end and assign it the head of the other linkedlist(which it was not traversing).
        //4. In the second iteration when both of the initial dummy heads are reversed then they will stand at point with the longer linkedlist dummy head already traversed the length diff.
        //5. Now keep traversing simultaneously until they meet at the intersection or any one of them reaches the end.
        //6. Return intersection point or -1 if they didn't meet. 
	public ListNode getIntersectionNode_better(ListNode headA, ListNode headB) {//My initial approach. Similar to Better approach.
       Stack<ListNode> headAStk = getHeadStack(headA);
       Stack<ListNode> headBStk = getHeadStack(headB);
       ListNode intersectBeginNode = null;
       while(!headAStk.empty() && !headBStk.empty()) {
           if(headAStk.peek() == headBStk.peek()){
               intersectBeginNode = headAStk.pop();
               headBStk.pop();
           }else
               break;
       }
        return intersectBeginNode;
    }
    private Stack<ListNode> getHeadStack(ListNode head){
        Stack<ListNode> headStk = new Stack<ListNode>();
        while(head != null){
            headStk.push(head);
            head = head.next;
        }
        return headStk;       
    }
    public ListNode getIntersectionNode_opt(ListNode headA, ListNode headB) {
    	ListNode dummyHeadA = new ListNode(-1);
        dummyHeadA = headA;
    	ListNode dummyHeadB = new ListNode(-1);
        dummyHeadB = headB;
       if(headA == null || headB == null) return null;
    	while(dummyHeadA != dummyHeadB) {
    		if(dummyHeadA == null) dummyHeadA = headB;
    		else if(dummyHeadB == null) dummyHeadB = headA;
    		else {
    			dummyHeadA = dummyHeadA.next;
    			dummyHeadB = dummyHeadB.next;
    		}
    	}
    	return (dummyHeadA != dummyHeadB || dummyHeadA == null || dummyHeadB == null) ? null : dummyHeadA; 
    }

}
