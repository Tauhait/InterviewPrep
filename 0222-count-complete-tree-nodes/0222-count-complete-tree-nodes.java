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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int level = 0;
        TreeNode copyRoot = root;
        while(copyRoot != null){
            level++;
            copyRoot = copyRoot.right;            
        }
        int lastLevel = countLastLevel(root, 0, level);
        
        // if((lastLevel & (lastLevel-1)) == 0){
        //     return lastLevel + (lastLevel-1);
        // }
        
        int ans = 0;
        // System.out.println(level+","+lastLevel);
        ans = ((1<<level)-1) + lastLevel;
        return ans;
    }
    private int countLastLevel(TreeNode rt, int level, int maxLevel){
        if(rt == null)
            return 0;
        if(rt.left == null && rt.right == null)
            return level == maxLevel ? 1 : 0;
        int count = countLastLevel(rt.left,  level+1, maxLevel) + 
                    countLastLevel(rt.right, level+1, maxLevel);
        return count;
    }
}