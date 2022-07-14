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
    private Map<Integer, Integer> inOrderMap;
    private int preOrderIndex;
    private int[] preOrder;
    
    public Solution(){
        this.inOrderMap = new HashMap<Integer, Integer>();
        this.preOrderIndex = 0;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preOrder = preorder;
        
	    for(int i = 0; i < inorder.length; i++) inOrderMap.put(inorder[i], i);

	    TreeNode root = buildTreeHelper(0, inorder.length-1);
	    return root;
	}
    //Using preorder to get current root val and 
    //inorder to build the tree by getting the root index from preorder
	public TreeNode buildTreeHelper(int left, int right) {
	    if(left > right) return null;
        
        int rootVal = preOrder[preOrderIndex++];
	    TreeNode root = new TreeNode(rootVal);

	    root.left = buildTreeHelper(left, inOrderMap.get(rootVal)-1);
	    root.right = buildTreeHelper(inOrderMap.get(rootVal)+1, right);

	    return root;
	}
}