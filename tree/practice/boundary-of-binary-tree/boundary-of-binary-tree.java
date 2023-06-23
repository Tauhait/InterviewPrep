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
    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
    private void leftBoundary(TreeNode node, List<Integer> boundary){
        while(node != null){
            if(!isLeaf(node)) boundary.add(node.val);
            node = node.left != null ? node.left : node.right;
        }
    }
    private void rightBoundary(TreeNode node, List<Integer> boundary, int pos){
        while(node != null){
            if(!isLeaf(node)) boundary.add(pos, node.val);
            node = node.right != null ? node.right : node.left;
        }
    }
    private void leafBoundary(TreeNode node, List<Integer> boundary){
        if(isLeaf(node)) { 
            boundary.add(node.val);
            return;
        }
        if(node.left  != null) leafBoundary(node.left,  boundary);
        if(node.right != null) leafBoundary(node.right, boundary);
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        boundary.add(root.val);
        if(isLeaf(root)) return boundary;
        leftBoundary(root.left, boundary);
        leafBoundary(root, boundary);
        rightBoundary(root.right, boundary, boundary.size());
        return boundary;
    }
}