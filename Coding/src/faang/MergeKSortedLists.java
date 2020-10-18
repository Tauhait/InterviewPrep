package faang;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	/*
Approach 1: Brute Force
Intuition & Algorithm

Traverse all the linked lists and collect the values of the nodes into an array.
Sort and iterate over this array to get the proper value of nodes.
Create a new sorted linked list and extend it with the new nodes.
As for sorting, you can refer here for more about sorting algorithms.
Complexity Analysis

Time complexity : O(N\log N)O(NlogN) where NN is the total number of nodes.

Collecting all the values costs O(N)O(N) time.
A stable sorting algorithm costs O(N\log N)O(NlogN) time.
Iterating for creating the linked list costs O(N)O(N) time.
Space complexity : O(N)O(N).

Sorting cost O(N)O(N) space (depends on the algorithm you choose).
Creating a new linked list costs O(N)O(N) space.



	 */
	class Node {
        int val;
        int pos;
        Node(){}
        Node(int x, int p){ val = x; pos = p; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode head = new ListNode(-1); 
        ListNode dummy = head;
        PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> n1.val - n2.val);
        ArrayList<ListNode> llHead = new ArrayList<ListNode>();
        int index = 0;
        for(ListNode n : lists) { 
            if(n == null) continue;
            llHead.add(n);
            Node newNode = new Node(n.val, index++);
            pq.add(newNode);
        }
        while(pq.peek() != null){
            Node e = pq.poll();
            int p = e.pos;
            if(llHead.get(p) != null){ 
                ListNode nextNode = llHead.get(p).next;
                llHead.set(p, nextNode);
                if(nextNode != null) {
                    Node newNode = new Node(nextNode.val, p);
                    pq.add(newNode);
                }
            }
            ListNode n = new ListNode(e.val);
            head.next = n;
            head = head.next;            
        }
        return dummy.next;
    }

}
