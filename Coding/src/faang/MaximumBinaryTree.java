package faang;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 */
public class MaximumBinaryTree {
	public class TreeNode {
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
	// Time - O(N*N) Space - O(1)
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    private TreeNode construct(int[] nums, int L, int R){
        if(L == R) return null;
        int maxIndex = getMaxIndex(nums, L, R);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, L, maxIndex);
        root.right = construct(nums, maxIndex + 1, R);
        return root;
    }
    private int getMaxIndex(int[] nums, int left, int right){
        int maxIndex = left;
        for(int i = left + 1; i < right; i++)
            if(nums[i] > nums[maxIndex]) maxIndex = i;
        return maxIndex;
    }
    //Time - O(N) Space - O(N)
    public TreeNode constructMaximumBinaryTreeUsingStack(int[] nums) {
    	/*
    	 * traverse the array once and create the node one by one. and use stack to store a decreasing sequence.
each step, we create a new curNode. compare to the peek of stack,
2.a. keep popping the stack while (stack.peek().val < curNode.val), and set the last popping node to be curNode.left.
Because the last one fulfilling the criteria is the largest number among curNode's left children. => curNode.left = last pop node
2.b. after popping up all nodes that fulfill (stack.peek().val < curNode.val),
thus (stack.peek().val > curNode.val), the stack.peek() is curNode's root => peek.right = curNode
return the bottom node of stack.
Deque: Deque<TreeNode> stack = new ArrayDeque<>();
    	 */
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        
        return stack.isEmpty() ? null : stack.removeLast();
    }

}
