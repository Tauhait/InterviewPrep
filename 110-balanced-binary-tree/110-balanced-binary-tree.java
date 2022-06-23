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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        boolean isBalc = true;
        if(!(Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1)) isBalc = false;
        if(!isBalanced(root.left)) isBalc = false;
        if(!isBalanced(root.right)) isBalc = false;
        return isBalc;
    }
    private int getHeight(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}