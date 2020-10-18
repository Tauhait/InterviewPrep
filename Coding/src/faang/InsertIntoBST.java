package faang;

public class InsertIntoBST {
	public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        helper(root, val);
        return root;
    }
    private void helper(TreeNode root, int val){
        if(root != null){
            if(root.left == null && root.right == null){
                TreeNode node = new TreeNode(val);
                if(node.val < root.val) root.left = node;
                else root.right = node;
            }else if(val > root.val) {
                if(root.right != null) helper(root.right, val);
                else root.right = new TreeNode(val);
            }else {
                if(root.left != null) helper(root.left, val);
                else root.left = new TreeNode(val);
            }            
        }        
    }

}
