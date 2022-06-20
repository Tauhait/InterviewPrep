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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        insert(root, val);
        return root;
    }
    private void insert(TreeNode root, int val){
        while(root != null && root.val != val){
            if(val < root.val){
                if(root.left == null) break;
                root = root.left;
            }else {
                if(root.right == null) break;
                root = root.right;
            }
        }
        TreeNode newNode = new TreeNode(val);
        if(val < root.val) root.left = newNode;
        else root.right = newNode; 
    }
}