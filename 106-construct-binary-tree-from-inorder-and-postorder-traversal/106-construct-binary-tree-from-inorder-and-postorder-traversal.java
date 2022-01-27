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
    Map<Integer, Integer> inorderValIndexMap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int index = 0; index < inorder.length; index++){
            inorderValIndexMap.put(inorder[index], index);
        }
        int len = inorder.length;
        int[] postIdx = new int[1];
        postIdx[0] = len - 1;
        return helper(inorder, postorder, 0, len - 1, postIdx);
    }
    private TreeNode helper(int[] inorder, int[] postorder, int left, int right, int[] postIdx){
        if(left > right){
            return null;
        }
        int nodeVal = postorder[postIdx[0]];
        postIdx[0]--;
        int inorderIndex = inorderValIndexMap.get(nodeVal);
        TreeNode node = new TreeNode(nodeVal);
        node.right = helper(inorder, postorder, inorderIndex + 1, right, postIdx);
        node.left = helper(inorder, postorder, left, inorderIndex - 1, postIdx);
        return node;
    }
}