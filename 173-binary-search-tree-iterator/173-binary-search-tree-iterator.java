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
    List<Integer> inorderList;
    int index;
    
    public BSTIterator(TreeNode root) {
        inorderList = new ArrayList<Integer>();
        index = 0;
        inorder(root);
    }
    
    private void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            inorderList.add(root.val);
            inorder(root.right);
        }
    }
    
    public int next() {
        int ans = inorderList.get(index++);
        return ans;
    }
    
    public boolean hasNext() {
        return index < inorderList.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */