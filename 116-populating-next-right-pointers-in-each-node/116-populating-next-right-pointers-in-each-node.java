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
        Queue<Node> queue = new LinkedList<Node>();
        int levels = levelCount(root, 0);
        queue.add(root);
        for(int level = 0; level < levels; level++){
            for(int nodes = 1; nodes <= (int)Math.pow(2, level); nodes++){
                Node node = queue.poll();
                queue.add(node.left);
                queue.add(node.right);   
            }
            
            List<Node> levelList = new LinkedList<Node>();
            while(!queue.isEmpty()){
                levelList.add(queue.poll());
            }
            int size = levelList.size();
            for(int i = 0; i < size - 1; i++){
                Node currentNode = levelList.get(i);
                Node nextNode = levelList.get(i + 1);
                currentNode.next = nextNode;
            }
            for(Node node : levelList){
                queue.add(node);
            }
            
        }
        return root;
    }
    public int levelCount(Node root, int level){
        if(root == null){
            return level - 1;
        }
        return levelCount(root.left, level + 1);
    }
}