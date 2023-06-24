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
    
    private TreeNode previous;
    private TreeNode inorderSuccessorNode;
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {        
        // Case 1: We simply need to find the leftmost node in the subtree rooted at p.right.
        if (p.right != null) {            
            TreeNode leftmost = p.right;            
            while (leftmost.left != null) {
                leftmost = leftmost.left;
            }            
            inorderSuccessorNode = leftmost;            
        } else {            
            // Case 2: We need to perform the standard inorder traversal and keep track of the previous node.
            findInorderSuccUsingPrevious(root, p);
        }
        return inorderSuccessorNode;     
    }

    private void findInorderSuccUsingPrevious(TreeNode node, TreeNode p){
      if(node == null) return;
      findInorderSuccUsingPrevious(node.left, p);
      if(inorderSuccessorNode != null) return;
      // Check if previous is the inorder predecessor of node
      if(previous == p) { 
        inorderSuccessorNode = node;
        return;
      }
      // Keeping previous up-to-date for further recursions
      previous = node;
      findInorderSuccUsingPrevious(node.right, p);
    }
}