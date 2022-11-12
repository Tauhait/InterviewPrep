/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Integer> map = new HashMap<>();
        Node copyHead = head;
        Node copyListHead = null;
        int index = 0;
        Node iterator = null;
        while(head != null){
            if(copyListHead == null){
                Node r = new Node(head.val);
                copyListHead = r;
                iterator = r;
            }else {
                Node r = new Node(head.val);
                iterator.next = r;
                iterator = iterator.next;
            }
            map.put(head, index++);
            head = head.next;
        }
        
        head = copyHead;
        int currentPos = 0;
        Node nextNode = copyListHead;
        while(head != null){
            iterator = copyListHead;
            if(head.random == null){
                nextNode.random = null;
                nextNode = nextNode.next;
                head = head.next;
                continue;
            }                
            int goTo = map.get(head.random);
            head = head.next;
            while(goTo-- > 0){
                iterator = iterator.next;
            }
            nextNode.random = iterator;
            nextNode = nextNode.next;
        }
        return copyListHead;
    }
}