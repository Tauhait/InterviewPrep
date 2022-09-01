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
    private int findGoodNodes(TreeNode node, int maxInPath){
        if(node == null) 
            return 0;
        int goodNodeCount = 0;
        if(node.val >= maxInPath) 
            goodNodeCount++;
        if(node.left != null) 
            goodNodeCount += findGoodNodes(node.left, Math.max(maxInPath, node.val));
        if(node.right != null) 
            goodNodeCount += findGoodNodes(node.right, Math.max(maxInPath, node.val));
        return goodNodeCount;
    }
    public int goodNodes(TreeNode root) {        
        return findGoodNodes(root, Integer.MIN_VALUE);
    }
}