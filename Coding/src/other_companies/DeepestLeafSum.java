package other_companies;

import java.util.LinkedList;

public class DeepestLeafSum {
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
	public int deepestLeavesSum(TreeNode root) {
        int height = getHeight(root);
        return deepestLeafSum(height, 0, root);
    }
    private int getHeight(TreeNode root){
        if(root.left == null && root.right == null) return 0;
        int left = 0, right = 0;
        if(root.left != null) left = getHeight(root.left);
        if(root.right != null) right = getHeight(root.right);
        return 1 + Math.max(left, right);
    }
    private int deepestLeafSum(int height, int nodeHeight, TreeNode root){        
        if(root.left == null && root.right == null) return nodeHeight == height ? root.val : 0;
        int sum = 0;
        if(root.left != null)  sum += deepestLeafSum(height, 1 + nodeHeight, root.left);
        if(root.right != null) sum += deepestLeafSum(height, 1 + nodeHeight, root.right);
        return sum;
    }
    public int deepestLeavesSumByLevelTraversalMethod(TreeNode root) {
        int res = 0, i;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            for (i = q.size() - 1, res = 0; i >= 0; --i) {
                TreeNode node = q.poll();
                res += node.val;
                if (node.right != null) q.add(node.right);
                if (node.left  != null) q.add(node.left);
            }
        }
        return res;
    }
}
