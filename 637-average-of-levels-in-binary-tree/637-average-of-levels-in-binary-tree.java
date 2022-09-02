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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new LinkedList<>();
        Deque<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        while(!nodeQ.isEmpty()){
            int size = nodeQ.size();
            double sum = 0.0;
            for(int j = 0; j < size; j++){
                TreeNode nodePoll = nodeQ.pollFirst();
                sum += nodePoll.val;
                if(nodePoll.left != null)
                    nodeQ.add(nodePoll.left);
                if(nodePoll.right != null)
                    nodeQ.add(nodePoll.right);
            }
            ans.add(sum/size);
        }
        return ans;
    }
}