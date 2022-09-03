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
    public boolean isCompleteTree(TreeNode root) {
        //do level order traversal and check the number of nodes in each level
        Deque<TreeNode> nodeQ = new LinkedList<>();
        nodeQ.add(root);
        boolean lastLevel = false;
        while(!nodeQ.isEmpty()){
            int size = nodeQ.size();            
            while(size-- > 0){
                TreeNode node = nodeQ.pollFirst();
                
                if(node.left != null)  {
                    if(!lastLevel) 
                        nodeQ.add(node.left);
                    else return false;
                }else lastLevel = true;
                
                if(node.right != null) { 
                    if(!lastLevel) 
                        nodeQ.add(node.right);
                    else return false;
                }else lastLevel = true;
            }
        }
        return true;
    }
}