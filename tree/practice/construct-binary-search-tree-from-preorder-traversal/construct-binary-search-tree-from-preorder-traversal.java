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
    private int preorderIndex;
    private TreeNode buildBST(int[] preorder, Map<Integer,Integer> bstMap, int low, int high){
        if(low > high) return null;
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);
        int indexInOrder = bstMap.get(rootVal);

        root.left  = buildBST(preorder, bstMap, low, indexInOrder - 1);
        root.right = buildBST(preorder, bstMap, indexInOrder + 1, high);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] inorder = new int[n];
        for(int i = 0; i < n; i++){
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        Map<Integer,Integer> bstMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            bstMap.put(inorder[i], i);
        }
        preorderIndex = 0;
        return buildBST(preorder, bstMap, 0, n - 1);
    }
}