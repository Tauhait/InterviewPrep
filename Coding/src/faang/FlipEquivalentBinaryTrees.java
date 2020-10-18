package faang;

public class FlipEquivalentBinaryTrees {
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
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        else if((root1 != null && root2 == null) || 
                (root1 == null && root2 != null)) return false;
        else if(root1.val != root2.val) return false; 
        else if((root1.left == null && root2.left != null)      || 
                (root1.right == null && root2.right != null)    ||
                (root1.left != null && root2.left == null)      ||
                (root1.right != null && root2.right == null)) {
            TreeNode temp = root1.left;
            root1.left = root1.right;
            root1.right = temp;
        }
        else {
            if(root1.left == null && root2.left == null) {}
            else if(root1.right == null && root2.right == null)  {}
            else if(root1.left.val != root2.left.val || root1.right.val != root2.right.val) {
                TreeNode temp = root1.left;
                root1.left = root1.right;
                root1.right = temp;
            }            
        }
        return flipEquiv(root1.left, root2.left) & flipEquiv(root1.right, root2.right);
    }
}
