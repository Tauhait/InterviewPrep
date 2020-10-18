package faang;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeToGreaterSumTree {
	//RRoL
    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root.right != null) bstToGst(root.right);
        pre += root.val;
        root.val = pre;
        if(root.left != null) bstToGst(root.left);
        return root;
    }
    public TreeNode bstToGst_ITER(TreeNode root) {
        int sum = 0;
        TreeNode current = root;
        Deque<TreeNode> Stk = new ArrayDeque<TreeNode>();
        while(current != null || !Stk.isEmpty()) {
            while(current != null) {
                Stk.push(current);
                current = current.right;
            }
            current = Stk.pop();
            current.val += sum;
            sum = current.val;
            current = current.left;
        }
        return root;
    }
}
