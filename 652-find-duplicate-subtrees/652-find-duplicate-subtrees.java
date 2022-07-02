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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        HashMap<String, Boolean> subs = new HashMap<String, Boolean>();
        helper(res, subs, root);
        return res;
    }
    
    public String helper(List<TreeNode> res, HashMap<String, Boolean> subs, TreeNode root){
        if(root==null) return ",X";
        String s = root.val+","+helper(res,subs,root.left)+helper(res,subs,root.right);
        if(subs.containsKey(s)){
            if(!subs.get(s)){
                res.add(root);
                subs.put(s, true);
            }            
        } else{
            subs.put(s, false);
        }
        return s;        
    }
}