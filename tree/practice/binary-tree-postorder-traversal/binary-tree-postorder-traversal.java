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
    public List<Integer> postorderTraversal(TreeNode root) {
        return morrisPostorderTraversal(root);
    }

    public List<Integer> morrisPostorderTraversal(TreeNode root) { // LRRo
        LinkedList<Integer> postorder = new LinkedList<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.right == null){
                postorder.addFirst(cur.val);
                cur = cur.left;
            } else {
                TreeNode successor = cur.right;
                while(successor.left != null && successor.left != cur){
                    successor = successor.left;
                }
                if(successor.left == null){
                    successor.left = cur;
                    postorder.addFirst(cur.val);
                    cur = cur.right;
                } else {
                    successor.left = null;
                    cur = cur.left;
                }
            }
        }
        return postorder;
    }
}