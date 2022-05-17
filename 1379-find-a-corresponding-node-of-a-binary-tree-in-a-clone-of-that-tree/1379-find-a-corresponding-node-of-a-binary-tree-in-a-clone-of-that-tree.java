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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned == null){
            return null;
        }
        if(target == original){
            return cloned;
        }
        TreeNode ref =  getTargetCopy(original.left, cloned.left, target);
        if(ref == null){
            ref =  getTargetCopy(original.right, cloned.right, target);
        }
        return ref;
    }
}