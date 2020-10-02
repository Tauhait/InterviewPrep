package rest;

import java.util.Stack;

public class SumOfRootToLeaf {
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
	public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 2 + root.val;
        return root.left == null && root.right == null ? val : dfs(root.left, val) + dfs(root.right, val);
    }
    // Iterative function to perform in-order traversal of the tree
    public static void inorderIterative(TreeNode root)
    {
    	// create an empty stack
    	Stack<TreeNode> stack = new Stack<TreeNode>();

    	// start from root node (set current node to root node)
    	TreeNode curr = root;

    	// if current node is null and stack is also empty, we're done
    	while (!stack.empty() || curr != null)
    	{
    		// if current node is not null, push it to the stack (defer it)
    		// and move to its left child
    		if (curr != null)
    		{
    			stack.push(curr);
    			curr = curr.left;
    		}
    		else
    		{
    			// else if current node is null, we pop an element from stack,
    			// print it and finally set current node to its right child
    			curr = stack.pop();
    			System.out.print(curr.val + " ");

    			curr = curr.right;
    		}
    	}
    }
}
