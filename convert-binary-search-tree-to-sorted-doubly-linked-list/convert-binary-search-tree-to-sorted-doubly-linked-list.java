/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
/*
Here is the algorithm :

Initiate the first and the last nodes as nulls.

Call the standard inorder recursion helper(root) :

    If node is not null :

        Call the recursion for the left subtree helper(node.left).

        If the last node is not null, link the last and the current node nodes.

        Else initiate the first node.

        Mark the current node as the last one : last = node.

        Call the recursion for the right subtree helper(node.right).

Link the first and the last nodes to close DLL ring and then return the first node.
*/

class Solution {
    private Node first;
    private Node last;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        first = null;
        last = null;
        convert(root);
        first.left = last;
        last.right = first;
        return first;
    }
    private void convert(Node root){
        if(root != null){
            convert(root.left);
            if(last != null){
                last.right = root;
                root.left = last;
            }else {
                first = root;
            }
            last = root;
            convert(root.right);            
        }
    }
}