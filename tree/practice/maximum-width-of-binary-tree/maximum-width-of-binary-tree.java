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
class Pair{
    int pos;
    TreeNode node;
    Pair(int x,TreeNode y){
        pos = x;
        node = y;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        int width = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            //to make the id starting from zero, prevent overflow
            int mmin = q.peek().pos;    
            
            int start = 0;
            int end = 0;
            for(int i = 0 ; i < size; i ++){
                int cur_id = q.peek().pos - mmin;
                TreeNode node = q.poll().node;;
                
                if(i == 0) start = cur_id;                
                if(i == size -1) end = cur_id;
                if(node.left != null){
                    q.offer(new Pair(2 * cur_id + 1,node.left));
                }
                if(node.right != null){
                    q.offer(new Pair(2 * cur_id + 2,node.right));
                }
            }
            width = Math.max(width, end - start + 1);
        }
        return width;
    }
}