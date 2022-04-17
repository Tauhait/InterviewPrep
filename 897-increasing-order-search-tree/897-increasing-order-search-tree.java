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
    TreeNode newNode = new TreeNode(-1);
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode newRoot = new TreeNode(-1);
        newRoot = newNode;
        helper(root);        
        return newRoot.right;
    }
    private void helper(TreeNode root){
        if(root != null){
            helper(root.left);
            // root.left = null;
            newNode.right = new TreeNode(root.val);
            // System.out.print(newNode.right.val + " ");
            newNode = newNode.right;            
            helper(root.right);
        }
    }
}