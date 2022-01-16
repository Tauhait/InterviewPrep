/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        
        HashMap<Node, Node> visited = new HashMap<Node, Node>();
        
        Queue<Node> bfsQ = new LinkedList<Node>();
        
        bfsQ.add(node);
        visited.put(node, new Node(node.val, new ArrayList<Node>()));
        
        while(!bfsQ.isEmpty()){
            Node q = bfsQ.remove();
            
            for(Node neighbor : q.neighbors){
                //visit the neighbor and make its clone
                if(!visited.containsKey(neighbor)){
                    
                    bfsQ.add(neighbor);
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));                    
                }
                // Add the clone of the neighbor to the neighbors of the clone node "q".
                Node neighborClone = visited.get(neighbor);
                Node qClone = visited.get(q);
                qClone.neighbors.add(neighborClone);
            }
        }
        return visited.get(node);
    }
}