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
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode current = root;
        Deque<TreeNode> Stk = new ArrayDeque<TreeNode>();
        while(current != null || !Stk.isEmpty()) {
            while(current != null) {
                Stk.push(current);
                current = current.right;
            }
            current = Stk.pop();
            current.val += sum;
            sum = current.val;
            current = current.left;
        }
        return root;
    }
}