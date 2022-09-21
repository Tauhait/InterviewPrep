/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Codec {

  // Encodes an n-ary tree to a binary tree.
  public TreeNode encode(Node root) {
    if (root == null) {
      return null;
    }

    TreeNode newRoot = new TreeNode(root.val);

    // Encode the first child of n-ary node to the left node of binary tree.
    if (root.children.size() > 0) {
      Node firstChild = root.children.get(0);
      newRoot.left = this.encode(firstChild);
    }

    // Encoding the rest of the sibling nodes.
    TreeNode sibling = newRoot.left;
    for (int i = 1; i < root.children.size(); ++i) {
      sibling.right = this.encode(root.children.get(i));
      sibling = sibling.right;
    }

    return newRoot;
  }

  // Decodes your binary tree to an n-ary tree.
  public Node decode(TreeNode root) {
    if (root == null) {
      return null;
    }

    Node newRoot = new Node(root.val, new ArrayList<Node>());

    // Decoding all the children nodes
    TreeNode sibling = root.left;
    while (sibling != null) {
      newRoot.children.add(this.decode(sibling));
      sibling = sibling.right;
    }

    return newRoot;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));