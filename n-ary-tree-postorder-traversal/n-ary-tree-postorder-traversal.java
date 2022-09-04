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
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        Stack<Integer> valueStack = new Stack<>();
        
        while (!nodeStack.isEmpty()) {
            root = nodeStack.pop(); 
            valueStack.push(root.val);
            for (int i = 0; i < root.children.size(); i++)
                nodeStack.add(root.children.get(i));
        }
        while(!valueStack.isEmpty()){
            ans.add(valueStack.pop());
        }
        return ans;
    }
}