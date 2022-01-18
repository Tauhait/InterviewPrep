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

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lOrderList = new ArrayList<List<Integer>>();
        if(root == null){
            return lOrderList;
        }
        Queue<Node> qLevel = new LinkedList<Node>();
        qLevel.offer(root);
        while(!qLevel.isEmpty()){
            int size = qLevel.size();
            List<Integer> lList = new ArrayList<Integer>();
            while(size-- > 0){
                Node parent = qLevel.poll();
                lList.add(parent.val);
                for(Node n : parent.children){
                    qLevel.offer(n);
                }
            }                        
            lOrderList.add(lList);
        }
        return lOrderList;
    }
}