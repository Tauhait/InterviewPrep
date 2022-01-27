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
    //int count = 0;
    private boolean isUni(TreeNode node, int val, int[] count){
        if(node == null){
            return true;
        }
        boolean left = isUni(node.left, node.val, count);
        boolean right = isUni(node.right, node.val, count);
        if(left && right){
            if(node.left != null && node.left.val != node.val){
                return false;
            }
            if(node.right != null && node.right.val != node.val){
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];//pass by ref and not copy, so retains the value
        isUni(root, 0, count);
        return count[0];
    }
}