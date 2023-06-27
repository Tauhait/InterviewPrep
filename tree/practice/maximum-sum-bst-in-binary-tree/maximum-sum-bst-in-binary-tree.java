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

    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        traverse(root);
        return maxSum;
    }

    private Result traverse(TreeNode node) {
        if (node == null)
            return new Result(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Result left = traverse(node.left);
        Result right = traverse(node.right);

        if (left.isValid && right.isValid && node.val > left.max && node.val < right.min) {
            int sum = left.sum + right.sum + node.val;
            maxSum = Math.max(maxSum, sum);
            int min = Math.min(left.min, node.val);
            int max = Math.max(right.max, node.val);
            return new Result(true, min, max, sum);
        }

        return new Result(false, 0, 0, 0);
    }

    private class Result {
        boolean isValid;
        int min;
        int max;
        int sum;

        public Result(boolean isValid, int min, int max, int sum) {
            this.isValid = isValid;
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
}