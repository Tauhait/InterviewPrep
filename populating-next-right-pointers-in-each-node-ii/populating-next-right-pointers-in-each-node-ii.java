/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> levelOrderList = new LinkedList<Node>();
        levelOrderList.offer(root);
        while(!levelOrderList.isEmpty()){
            int size = levelOrderList.size();
            List<Node> llist = new LinkedList<Node>();
            while(size-- > 0){
                Node currNode = levelOrderList.poll();
                llist.add(currNode);
                if(currNode.left != null){
                    levelOrderList.offer(currNode.left);
                }
                if(currNode.right != null){
                    levelOrderList.offer(currNode.right);
                }
            }
            for(int i = 0; i < llist.size() - 1; i++){
                Node first = llist.get(i);
                Node second = llist.get(i + 1);
                first.next = second;
            }
        }
        return root;
    }
}