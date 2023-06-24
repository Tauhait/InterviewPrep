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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }else if(nums.length == 1){
            return new TreeNode(nums[0]);
        }else {
            int left = 0;
            int right = nums.length - 1;
            return buildAVLTree(nums, left, right);
        }        
    }
    private TreeNode buildAVLTree(int[] nums, int left, int right){
        if(left <= right){
            int mid = left + (right - left)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = buildAVLTree(nums, left, mid - 1);
            root.right = buildAVLTree(nums, mid + 1, right);
            return root;
        }
        return null;
    }
    
}