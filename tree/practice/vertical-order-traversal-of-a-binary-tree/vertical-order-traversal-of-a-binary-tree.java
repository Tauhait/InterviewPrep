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
 class Triplet implements Comparable<Triplet> {
    Integer row;
    Integer col;
    Integer val;
    public Triplet(int r, int c, int v){
        row = r;
        col = c;
        val = v;
    }
    @Override
    public int compareTo(Triplet other){
        if(this.col == other.col){
            if(this.row == other.row){
                return this.val.compareTo(other.val);
            }
            return this.row.compareTo(other.row);
        }
        return this.col.compareTo(other.col);
    }
 }

class Solution {
    private void inorder(TreeNode root, int row, int col, PriorityQueue<Triplet> queue){
        if(root != null){
            inorder(root.left, row + 1, col - 1, queue);
            queue.offer(new Triplet(row, col, root.val));
            inorder(root.right, row + 1, col + 1, queue);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();
        var queue = new PriorityQueue<Triplet>();
        inorder(root, 0, 0, queue);
        var result = new ArrayList<List<Integer>>();
        while(!queue.isEmpty()){
            Triplet node = queue.poll();
            var layer = new ArrayList<Integer>();
            layer.add(node.val);
            while(!queue.isEmpty() && queue.peek().col == node.col){
                layer.add(queue.poll().val);
            }
            result.add(layer);
        }
        return result;
    }
}