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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;            
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left == null && right == null){
            return null;
        }  
        if(left != null && right != null){
            return root;
        }
        return left == null ? right : left;
    }
    /*
    LinkedList<TreeNode> route;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode answer = null;
        route = new LinkedList<TreeNode>();
        LinkedList<TreeNode> routeQ = null;
        LinkedList<TreeNode> routeP = null;
        if(findRoute(root, p)){
            routeP = (LinkedList)route.clone();
        }
        
        route = new LinkedList<TreeNode>();
        
        if(findRoute(root, q)){
            routeQ = (LinkedList)route.clone();
        }
        if(routeP == null || routeQ == null){
            return answer;
        }
        
        int idx = 0;
        while(idx < routeP.size() && idx < routeQ.size()){
            if(routeP.get(idx).val == routeQ.get(idx).val){
                answer = routeP.get(idx);
            }
            idx++;
        }
        
        return answer;
        
    }
    private boolean findRoute(TreeNode root, TreeNode node){
        if(root == null){
            return false;
        }
        route.add(root);        
        if(root.val == node.val){
            return true;
        }
              
        if(findRoute(root.left, node) || findRoute(root.right, node)){
            return true;
        } 
        route.remove(route.size() - 1);
        return false;
    }
    */
}
