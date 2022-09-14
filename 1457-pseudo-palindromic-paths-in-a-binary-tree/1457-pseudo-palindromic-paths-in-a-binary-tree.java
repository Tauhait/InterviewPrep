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
    private Map<Integer,Integer> freq;
    public Solution(){
        pseudoCount = 0;
        freq = new HashMap<Integer,Integer>();
    }    
    private boolean isPalindrome(){
        int odds  = 0;
        int evens = 0;
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(entry.getValue() % 2 == 1) ++odds;
            else evens++;
            if(odds > 1) return false;
        }       
        return true;
    }
    private void helper(TreeNode node){
        if(node.left == null && node.right == null){
            freq.put(node.val, freq.getOrDefault(node.val,0)+1);
            if(isPalindrome()) 
                ++pseudoCount;
            freq.put(node.val, freq.get(node.val)-1);
            return;
        }
        freq.put(node.val, freq.getOrDefault(node.val,0)+1);
        
        if(node.left != null)  helper(node.left);
        
        if(node.right != null) helper(node.right);
        
        freq.put(node.val, freq.get(node.val)-1);
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root.left == null && root.right == null) return 1;
        helper(root);
        return pseudoCount;
    }
}