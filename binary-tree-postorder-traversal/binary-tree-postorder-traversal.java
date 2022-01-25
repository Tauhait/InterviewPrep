class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> postorderList = new LinkedList<Integer>();
        if(root == null) return postorderList;
        preorder(root, postorderList);
        return postorderList;
    }
    private void preorder(TreeNode root, LinkedList<Integer> postlist){
        if(root != null){
            preorder(root.left, postlist);
            preorder(root.right, postlist);
            postlist.add(root.val);
        }
    }
}