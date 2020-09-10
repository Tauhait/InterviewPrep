package other_companies;

import java.util.Stack;

public class FlattenMultilevel_DLL {
	class Node {
	    public int val;
	    public Node prev;
	    public Node next;
	    public Node child;
	}
	public Node flatten(Node head) {
        if(head == null) return head;
        Node flattenHead = new Node();
        flattenHead.next = head;
        traverse(head);
        return flattenHead.next;
    }
    private void traverse(Node head){
       Stack<Node> childStk = new Stack<Node>();
        while(true){
            if(head.child != null && head.next != null) { 
                head.next.prev = null;
                childStk.push(head.next);
                head.child.prev = head;
                head.next = head.child;
                head.child = null;
            }else if(head.child != null && head.next == null){
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
            }else if(head.child == null && head.next != null){
                head = head.next;
            }else if(!childStk.empty()){
                Node nxtLink = childStk.pop();
                nxtLink.prev = head;
                head.next = nxtLink;
            }else break;
        }  
        
    }

}
