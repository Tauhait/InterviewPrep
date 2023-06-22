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
        q.offer(new Pair(0,root));
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            int start = 0;
            int end = 0;
            for(int i = 0 ; i < size; i ++){
                Pair p = q.poll();
                int pos = p.pos;
                TreeNode node = p.node;
                
                if(i == 0){
                    start = pos;
                }
                if(i == size -1){
                    end = pos;
                }
                if(node.left != null){
                    q.offer(new Pair(2*pos+1,node.left));
                }
                if(node.right != null){
                    q.offer(new Pair(2*pos+2,node.right));
                }
            }
            max = Math.max(max,end+1-start);
        }
        return max;
    }
}