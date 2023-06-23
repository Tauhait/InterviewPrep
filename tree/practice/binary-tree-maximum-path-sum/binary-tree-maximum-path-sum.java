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
    int maxSum;
    private int solve(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = solve(root.left);
        int r = solve(root.right);
        int sum_found_at_bottom = l + r + root.val;
        int sum_only_left  = l + root.val;
        int sum_only_right = r + root.val;
        int sum_only_root  = root.val;
        maxSum = Math.max(maxSum, 
                        Math.max(sum_found_at_bottom, 
                            Math.max(sum_only_left, 
                                Math.max(sum_only_root, sum_only_right))));
        return Math.max(sum_only_left, 
                            Math.max(sum_only_root, sum_only_right));
    }
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}