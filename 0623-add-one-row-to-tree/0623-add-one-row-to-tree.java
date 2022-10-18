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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        dq.add(root);
        depth--;
        while(!dq.isEmpty() && depth > 0){
            int sz = dq.size();
            List<TreeNode> lastLevel = new ArrayList<TreeNode>();
            while(sz-- > 0){
                TreeNode node = dq.poll();
                lastLevel.add(node);
                if(depth == 1){
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    node.left = new TreeNode(val);
                    if(left != null)
                        node.left.left = left;
                    node.right = new TreeNode(val);
                    if(right != null)
                        node.right.right = right;
                }
                if(node.left != null)
                    dq.add(node.left);
                if(node.right != null)
                    dq.add(node.right);
                               
            }
            if(dq.size() == 0){
                for(int i = 0; i < lastLevel.size(); i++){
                    TreeNode node = lastLevel.get(i);
                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);
                }
            }
            depth--;
        }
        return root;
    }
}