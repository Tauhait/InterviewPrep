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
    private Stack<String> bt2str;
    
    public Solution(){
        bt2str = new Stack<>();
    }
    private void helper(TreeNode root){        
        if(root == null) return;        
        bt2str.push("(");
        bt2str.push(root.val+"");
        if(root.left == null && root.right != null) {
            bt2str.push("(");
            bt2str.push(")");
        }
        helper(root.left);
        helper(root.right);
        
        bt2str.push(")");
    }
    public String tree2str(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        helper(root);
        bt2str.pop();
        while(bt2str.size() > 1){
            ans.insert(0, bt2str.pop());
        }            
        return ans.toString();
    }
}