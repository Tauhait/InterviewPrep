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
// since the height of a tree is always greater than or equal to 0
// we use -1 as a flag to indicate if the subtree is not balanced
/**
But if you notice, with the top down approach we are calculating the height at each node Log N times. This is redundant. I tried adding a Map that would record the depth at each Node as we go down the tree, and during each subsequent height calculation we can access from the map cache. This route somehow added more overhead in time complexity... not sure why.

The better approach would be to find the height from the bottom up.
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }
    
    private int getHeight(TreeNode node) {
        if (node == null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        // left, right subtree is unbalanced or cur tree is unbalanced
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}