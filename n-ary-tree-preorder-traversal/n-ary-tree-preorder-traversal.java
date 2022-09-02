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
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;
        Deque<Node> nodeQ = new LinkedList<Node>();
        nodeQ.add(root);
        while(!nodeQ.isEmpty()){
            int size = nodeQ.size();            
            while(size-- > 0){
                Node node = nodeQ.pollFirst();
                ans.add(node.val);
                List<Node> tmp = new ArrayList<Node>();
                for(Node child : node.children)
                    tmp.add(child);                
                for(int i = tmp.size()-1; i >= 0; i--)
                    nodeQ.addFirst(tmp.get(i));
            }
            
        }
        return ans;
    }
}