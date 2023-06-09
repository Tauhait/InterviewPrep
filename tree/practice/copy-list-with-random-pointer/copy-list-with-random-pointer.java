/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
public class Solution {
  // Visited dictionary to hold old node reference as "key" and new node reference as the "value"
  HashMap<Node, Node> visited = new HashMap<Node, Node>();

  public Node getClonedNode(Node node) {
    // If the node exists then
    if (node != null) {
      // Check if the node is in the visited dictionary
      if (this.visited.containsKey(node)) {
        // If its in the visited dictionary then return the new node reference from the dictionary
        return this.visited.get(node);
      } else {
        // Otherwise create a new node, add to the dictionary and return it
        this.visited.put(node, new Node(node.val, null, null));
        return this.visited.get(node);
      }
    }
    return null;
  }

  public Node copyRandomList(Node head) {

    if (head == null) {
      return null;
    }

    Node oldNode = head;

    // Creating the new head node.
    Node newNode = new Node(oldNode.val);
    this.visited.put(oldNode, newNode);

    // Iterate on the linked list until all nodes are cloned.
    while (oldNode != null) {
      // Get the clones of the nodes referenced by random and next pointers.
      newNode.random = this.getClonedNode(oldNode.random);
      newNode.next = this.getClonedNode(oldNode.next);

      // Move one step ahead in the linked list.
      oldNode = oldNode.next;
      newNode = newNode.next;
    }
    return this.visited.get(head);
  }
}