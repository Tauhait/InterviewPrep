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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        
        return isPathSum(root, root.val, targetSum);
    }
    private boolean isPathSum(TreeNode root, int sum, int targetSum){
        if(root != null && root.left == null && root.right == null && sum == targetSum){
            return true;
        }
        if(root.left != null && isPathSum(root.left, sum + root.left.val, targetSum)){
            return true;
        }
        if(root.right != null && isPathSum(root.right, sum + root.right.val, targetSum)){
            return true;
        }
        return false;
    }
}