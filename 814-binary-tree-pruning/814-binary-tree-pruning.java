/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(root.left == null && root.right == null){//its a leaf
            if(root.val == 0) root = null;
            return root;
        }
        TreeNode left = null, right = null;
        if(root.left != null)
            left = pruneTree(root.left);        
        if(root.right != null)
            right = pruneTree(root.right);
        
        if(left == null) root.left = null;
        if(right == null) root.right = null;
        
        if(root.val == 0) {
            if(left == null && right == null) root = null;
        }
        return root;
    }
}