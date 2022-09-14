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
    private int pseudoCount;
    private int[] freq;
    public Solution(){
        pseudoCount = 0;
        freq = new int[11];
    }    
    private boolean isPalindrome(){
        int odds  = 0;
        for(int val : freq){
            if((val & 1) == 1) ++odds;
            if(odds > 1) return false;
        }       
        return true;
    }
    private void helper(TreeNode node){
        if(node.left == null && node.right == null){
            freq[node.val]++;
            if(isPalindrome()) 
                ++pseudoCount;
            freq[node.val]--;
            return;
        }
        freq[node.val]++;
        
        if(node.left != null)  helper(node.left);
        
        if(node.right != null) helper(node.right);
        
        freq[node.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        // if(root.left == null && root.right == null) return 1;
        helper(root);
        return pseudoCount;
    }
}