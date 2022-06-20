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
class Solution {
    /**
     * findSuccesor - Helper function for finding successor
     * In BST, succesor of root is the leftmost child in root's right subtree
     */
    private TreeNode findSuccessor(TreeNode root) {
        TreeNode cur = root.right;
        while (cur != null && cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        // return null if root is null
        if (root == null) {
            return root;
        }

        // delete current node if root is the target node
        if (root.val == key) {
            // replace root with root->right if root->left is null	
            if (root.left == null) {
                return root.right;
            }

            // replace root with root->left if root->right is null
            if (root.right == null) {
                return root.left;
            }

            // replace root with its successor if root has two children
            TreeNode p = findSuccessor(root);
            root.val = p.val;
            root.right = deleteNode(root.right, p.val);
            return root;
        }
        if (root.val < key) {
            // find target in right subtree if root->val < key
            root.right = deleteNode(root.right, key);
        } else {
            // find target in left subtree if root->val > key
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

}