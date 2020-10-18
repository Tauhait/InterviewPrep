package faang;

public class AVLTreeInsert {
	/*
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        TreeNode root = new TreeNode();
        root.val = head.val;
        insertIntoBST(root, head.next);
        return root;        
    }
    private void insertIntoBST(TreeNode root, ListNode head){
        while(head != null){
            TreeNode newNode = new TreeNode();
            newNode.val = head.val;
            findPlaceToInsert(root, newNode);
            head = head.next;
            if(!isBalanced(root)) {
                
            }
        }
    }
    private void findPlaceToInsert(TreeNode root, TreeNode newNode){
        if(val > root.val && root.right != null) return findPlaceToInsert(val, root.right);
        else if(val > root.val && root.right == null)  root.right = newNode;
        else if(val <= root.val && root.left != null) return findPlaceToInsert(val, root.left);
        else if(val <= root.val && root.left == null) root.left = newNode;
        
    }
    private int findNodeHeight(TreeNode node){
        if(node == null) return 0;
        return 1 + Math.max(findNodeHeight(node.left), findNodeHeight(node.right));
    }
    private void rotateLeft(TreeNode node){
        
    }
    private boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int leftH = findNodeHeight(root.left);
        int rightH = findNodeHeight(root.right);
        int balcF = Math.abs(leftH - rightH);
        if(balcF > 1) return false;
        return isBalanced(root.left) & isBalanced(root.right);
    }
*/
}
