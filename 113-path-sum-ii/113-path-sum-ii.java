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
    private List<List<Integer>> paths;
    
    private void findPaths(TreeNode node, int targetSum, List<Integer> path, int sum){
        if(node.left == null && node.right == null){
            if(sum + node.val == targetSum){
                path.add(node.val);
                paths.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }            
        }
        sum += node.val;
        path.add(node.val);
        if(node.left != null)
            findPaths(node.left, targetSum, path, sum);
        if(node.right != null)
            findPaths(node.right, targetSum, path, sum);
        sum -= node.val;
        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        paths = new ArrayList<List<Integer>>();
        if(root == null)
            return paths;
        findPaths(root, targetSum, new ArrayList<Integer>(), 0);
        return paths;
    }
}