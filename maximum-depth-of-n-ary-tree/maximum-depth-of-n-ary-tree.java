/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int level = 0;
        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int sz = queue.size();
            level++;
            while(sz-- > 0){
                Node n = queue.poll();
                for(Node child : n.children){
                    queue.add(child);
                }
            }
        }
        return level;
    }
}