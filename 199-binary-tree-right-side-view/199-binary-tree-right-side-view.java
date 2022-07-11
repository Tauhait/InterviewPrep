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
    private final int delim = -101;
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> bfsQ = new LinkedList<TreeNode>();
        List<Integer> levelOrderTraversal = new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        bfsQ.add(root);
        while(!bfsQ.isEmpty()){
            int size = bfsQ.size();
            while(size-- > 0){
                TreeNode child = bfsQ.poll();
                levelOrderTraversal.add(child.val);
                if(child.left != null) bfsQ.add(child.left);
                if(child.right != null) bfsQ.add(child.right);
            }
            levelOrderTraversal.add(delim);
        }
        for(int i = 0; i < levelOrderTraversal.size(); i++){
            if(levelOrderTraversal.get(i) == delim) ans.add(levelOrderTraversal.get(i-1));
        }
        return ans;
    }
}