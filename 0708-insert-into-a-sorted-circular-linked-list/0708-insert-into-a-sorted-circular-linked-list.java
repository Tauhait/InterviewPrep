class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }
        Node node = head;
        
        while(node.next != head) {
            if(node.val <= node.next.val) {
                if(insertVal >= node.val && insertVal <= node.next.val) {
                    break;
                }
            } else {
                if(insertVal >= node.val || insertVal <= node.next.val) {
                    break;
                }
            }
            node = node.next;
        }
        
        Node next = node.next;
        node.next = new Node(insertVal, next);
        return head;
    }
}