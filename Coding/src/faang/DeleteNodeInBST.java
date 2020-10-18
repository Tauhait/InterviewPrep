package faang;

import java.util.Stack;

public class DeleteNodeInBST {
	public TreeNode deleteNode(TreeNode root, int key) {        
        if(root == null) return root;
        TreeNode keyNode = find(root, key);
        if(keyNode == null) return root;
        
        if(keyNode.right == null){
            if(keyNode == root) return root.left;            
            Stack<TreeNode> traverse = new Stack<TreeNode>();
            traverse.push(root);
            while(!traverse.empty()) {
                TreeNode dummy = traverse.pop();
                if(dummy.left == keyNode) {
                    dummy.left = dummy.left.left;
                    break;
                }else if(dummy.right == keyNode) {
                    dummy.right = dummy.right.left;
                    break;
                }else {
                    if(dummy.left != null) traverse.push(dummy.left);
                    if(dummy.right != null) traverse.push(dummy.right);
                }
            }            
        }else if(keyNode.right.left == null) {
            keyNode.val = keyNode.right.val;
            keyNode.right = keyNode.right.right;
        }else {
            TreeNode decendent = findSuccessor(keyNode.right);
            keyNode.val = decendent.left.val;
            decendent.left = decendent.left.right;
        }
       return root;
    }
    private TreeNode find(TreeNode root, int key){
        if(root == null) return null;
        else if(root.val == key) return root;
        else if(root.val < key) return find(root.right, key);
        else return find(root.left, key);
    }
    private TreeNode findSuccessor(TreeNode root){
        if(root.left.left == null) return root;
        return findSuccessor(root.left);
    }	
    //==============================================================================
    public TreeNode deleteNode_OPT(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key) root.left = deleteNode(root.left, key);
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else { // found node to be deleted
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            // node with two children, replace with the inOrder successor(minVal) in the right subtree
            root.val = getMin(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    private int getMin(TreeNode root) {
        while (root.left != null) {root = root.left;}
        return root.val;
    }

}
