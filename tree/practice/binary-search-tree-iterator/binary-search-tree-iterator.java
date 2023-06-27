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
class BSTIterator {
    TreeNode nextRef;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        nextRef = root;
        stack = new Stack<>();
        while(nextRef != null){
            stack.push(nextRef);
            nextRef = nextRef.left;
        }
    }
    
    public int next() {
        int retVal = stack.peek().val;
        nextRef = stack.pop();
        if(nextRef.right != null) { 
            nextRef = nextRef.right;                
            while(nextRef != null){
                stack.push(nextRef);
                nextRef = nextRef.left;
            }
        }
        return retVal;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */