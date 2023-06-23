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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> dque = new ArrayDeque<>();
        dque.add(root);
        
        boolean alternate = true;
        while(!dque.isEmpty()){
            int sz = dque.size();
            List<Integer> branch = new ArrayList<Integer>();
            while(sz-- > 0){                
                TreeNode node = dque.pollFirst();
                if(alternate){//left->right
                    branch.add(node.val);
                }else {//right->left
                    branch.add(0,node.val);
                }
                if(node.left  != null) dque.addLast(node.left);
                if(node.right != null) dque.addLast(node.right);
            }
            alternate = !alternate;
            ans.add(branch);
        }
        return ans;
    }
}