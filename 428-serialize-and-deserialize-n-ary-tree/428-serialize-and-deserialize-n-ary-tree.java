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

class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        this._serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void _serializeHelper(Node root, StringBuilder sb) {
        
        // Queue to perform a level order traversal of the tree
        Queue<Node> q = new LinkedList<Node>();
        
        // Two dummy nodes that will help us in serialization string formation.
        // We insert the "endNode" whenever a level ends and the "childNode"
        // whenever a node's children are added to the queue and we are about
        // to switch over to the next node.
        Node endNode = new Node();
        Node childNode = new Node();
        q.add(root);
        q.add(endNode);
        
        while (!q.isEmpty()) {
            
            // Pop a node
            Node node = q.poll();
            
            // If this is an "endNode", we need to add another one
            // to mark the end of the current level unless this
            // was the last level.
            if (node == endNode) {
                
                // We add a sentinal value of "#" here
                sb.append('#');
                if (!q.isEmpty()) {
                    q.add(endNode);  
                }
            } else if (node == childNode) {
                
                // Add a sentinal value of "$" here to mark the switch to a
                // different parent.
                sb.append('$');
            } else {
                
                // Add value of the current node and add all of it's
                // children nodes to the queue. Note how we convert
                // the integers to their corresponding ASCII counterparts.
                sb.append((char) (node.val + '0'));
                for (Node child : node.children) {
                    q.add(child);
                }
                
                // If this not is NOT the last one on the current level, 
                // add a childNode as well since we move on to processing
                // the next node.
                if (q.peek() != endNode) {
                    q.add(childNode);
                }
            }
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
            
        Node rootNode = new Node(data.charAt(0) - '0', new ArrayList<Node>());
        this._deserializeHelper(data, rootNode);
        return rootNode;
    }
    
    private void _deserializeHelper(String data, Node rootNode) {  
        
        // We move one level at a time and at every level, we need access
        // to the nodes on the previous level as well so that we can form
        // the children arrays properly. Hence two arrays.
        LinkedList<Node> currentLevel = new LinkedList<Node>();
        LinkedList<Node> prevLevel = new LinkedList<Node>();
        currentLevel.add(rootNode);
        Node parentNode = rootNode;
        
        // Process the characters in the string one at a time.
        for (int i = 1; i < data.length(); i++) {
            char d = data.charAt(i);
            if (d == '#') {
                // Special processing for end of level. We need to swap the
                // array lists. Here, we simply re-initialize the "currentLevel"
                // arraylist rather than clearing it.
                prevLevel = currentLevel;
                currentLevel = new LinkedList<Node>();
                
                // Since we move one level down, we take the parent as the first
                // node on the current level.
                parentNode = prevLevel.poll();
            } else {
                if (d == '$') {
                    
                    // Special handling for change in parent on the same level
                    parentNode = prevLevel.poll();
                } else {
                    Node childNode = new Node(d - '0', new ArrayList<Node>());    
                    currentLevel.add(childNode);
                    parentNode.children.add(childNode);
                }
            }
        }
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));