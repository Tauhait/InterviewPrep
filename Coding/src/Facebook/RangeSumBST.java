package Facebook;

public class RangeSumBST {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	      }
	}
	///* Without class Variable
    public int rangeSumBST(TreeNode root, int L, int R) {       
        if(root == null) return 0;
        if(root.val > R) return rangeSumBST(root.left, L, R);
        if(root.val < L) return rangeSumBST(root.right, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);        
    }
    //*/
    
    /* With class variable
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        inOrder(root, L, R);
        return sum;
    }
    private void inOrder(TreeNode root, int L, int R){
        if(root != null) {
            inOrder(root.left, L, R);
            if(root.val >= L && root.val <= R) sum += root.val;
            inOrder(root.right, L, R);
        }
    }
    */

}
