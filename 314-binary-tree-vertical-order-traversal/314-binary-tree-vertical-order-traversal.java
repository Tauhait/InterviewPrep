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
    TreeMap<Integer, List<NodeOrder>> sortedNodesByOrder;
    class NodeOrder {
        TreeNode node;
        int level;
        int order;
        public NodeOrder(TreeNode node, int order, int level){
            this.node = node;
            this.order = order;
            this.level = level;
        }
    }
    private void traverseInOrder(TreeNode node, int order, int level){
        if(node != null){
            NodeOrder nOrder = new NodeOrder(node, order, level);
            sortedNodesByOrder.putIfAbsent(order, new LinkedList<NodeOrder>());
            List<NodeOrder> nOrderList = sortedNodesByOrder.get(order);
            nOrderList.add(nOrder);
            sortedNodesByOrder.put(order, nOrderList);
            traverseInOrder(node.left,  order-1, level+1);
            traverseInOrder(node.right, order+1, level+1);
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        sortedNodesByOrder = new TreeMap<>();
        traverseInOrder(root, 0, 0);
        while(!sortedNodesByOrder.isEmpty()){
            Map.Entry<Integer,List<NodeOrder>> entry = sortedNodesByOrder.pollFirstEntry();
            List<NodeOrder> nodes = entry.getValue();
            Collections.sort(nodes, (A, B)->(A.level - B.level));
            List<Integer> ordered = new LinkedList<>();
            for(NodeOrder no : nodes){
                ordered.add(no.node.val);
            }
            ans.add(ordered);
        }
        return ans;
    }
}