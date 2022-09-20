public String serialize(Node root) {
StringBuilder sb = new StringBuilder();
this._serializeHelper(root, sb);
return sb.toString();
}
private void _serializeHelper(Node root, StringBuilder sb) {
// To be written for every approach
}
​
// Decodes your encoded data to tree.
public Node deserialize(String data) {
if(data.isEmpty())
return null;
Node rootNode = new Node(data.charAt(0) - '0', new ArrayList<Node>());
WrappableInt index = new WrappableInt(1);
this._deserializeHelper(data, rootNode, index);
return rootNode;
}
private void _deserializeHelper(String data, Node node, WrappableInt index) {
// To be written for every approach.
}
}
```