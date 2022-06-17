/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode succ = null;
    TreeNode prev = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        getInorderSucc(root, p);
        return succ;
    }
    private void getInorderSucc(TreeNode node, TreeNode p){
        if(node != null){
            getInorderSucc(node.left, p);
            if(prev != null && succ == null) succ = node;
            if(node.val == p.val) prev = node;
            getInorderSucc(node.right, p);
            
        }
    }
}