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
    public int closestValue(TreeNode root, double target) {
        int rounded = (int)Math.round(target);
        return binarySearch(root, root, rounded);
    }
    private int binarySearch(TreeNode parent, TreeNode root, int target){        
        if(target == root.val) return root.val;
        else if(target < root.val && root.left != null) return binarySearch(root, root.left, target);
        else if(target > root.val && root.right != null) return binarySearch(root, root.right, target);
        else {
            int diffParent = Math.abs(target - parent.val);
            int diffChild = Math.abs(target - root.val);
            if(diffParent < diffChild) return parent.val;
            else return root.val;
        }
    }
}