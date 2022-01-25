/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<Integer>();
        List<Integer> inorderList = new ArrayList<>();
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(root);
        while(!treeNodeStack.empty()){
           
            while(root != null && root.left != null){
                root = root.left;
                treeNodeStack.push(root);
                
            }
            
            if(!treeNodeStack.empty()){
               root = treeNodeStack.pop();                   
               inorderList.add(root.val);
            }            
            
           if(root.right != null){
                root = root.right;
                treeNodeStack.push(root);                
            }else {               
               root=null;
           }          
        }
        return inorderList;
    }
}