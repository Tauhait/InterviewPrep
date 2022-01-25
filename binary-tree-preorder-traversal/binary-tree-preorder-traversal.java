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
    public List<Integer> preorderTraversal(TreeNode root) {        
        LinkedList<Integer> preorderList = new LinkedList<Integer>();
        if(root == null) return preorderList;
        preorder(root, preorderList);
        return preorderList;
    }
    private void preorder(TreeNode root, LinkedList<Integer> prelist){
        if(root != null){
            prelist.add(root.val);
            preorder(root.left, prelist);
            preorder(root.right, prelist);
        }
    }
}