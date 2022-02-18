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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new LinkedList<TreeNode>();
        }
        return buildTrees(1, n);
    }
    private List<TreeNode> buildTrees(int start, int end){        
        List<TreeNode> listOfBST = new LinkedList<TreeNode>();
        if(start > end){
            listOfBST.add(null);
            return listOfBST;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> lCombinations = buildTrees(start, i - 1);
            List<TreeNode> rCombinations = buildTrees(i + 1, end);
            
            for(TreeNode leftTree : lCombinations){ 
               for(TreeNode rightTree : rCombinations){
                   TreeNode tree = new TreeNode(i);
                   tree.left = leftTree;
                   tree.right = rightTree; 
                   listOfBST.add(tree);
                }                
            }            
        }
        return listOfBST;
    }
}