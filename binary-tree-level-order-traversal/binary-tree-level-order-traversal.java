/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return (new ArrayList<List<Integer>>());
        
        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(queue.peek() != null){
        	List<Integer> rowLevelList = new ArrayList<Integer>();
        	int len = queue.size();
        	for(int i = 1; i <= len; i++) {
	            TreeNode t = queue.poll();	            
	            rowLevelList.add(t.val);	            	            	
                if(t.left != null) queue.offer(t.left);
                if(t.right != null) queue.offer(t.right);
            }      
	        
            if(rowLevelList.size() > 0) levelOrderList.add(rowLevelList);
        }
        return levelOrderList;
    }
}