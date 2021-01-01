package faang;

import java.util.LinkedList;
import java.util.List;

public class AllNodesAtDistKFromBT {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new LinkedList<Integer>();
        int vertexDistFromRootToTarget = dfs(ans, root, target, K);
        System.out.println(vertexDistFromRootToTarget);
        return ans;
    }
    
    /* Return the number of vertices on the path from node to target from node to target if exists, else -1. */
    private int dfs(List<Integer> ans, TreeNode t, TreeNode target, int K){
        if(t == null) return -1;
        else if(t == target) {
            subtree_add(ans, t, 0, K);
            return 1;
        }
        else {
            int L = dfs(ans, t.left, target, K),
                R = dfs(ans, t.right, target, K);
            if(L != -1) {
                if(L == K) ans.add(t.val);
                subtree_add(ans, t.right, L + 1, K);
                return L + 1;
            }
            else if(R != -1){
                if(R == K) ans.add(t.val);
                subtree_add(ans, t.left, R + 1, K);
                return R + 1;
            }
            else {
                return -1;
            }            
        }
    }
    
    /*  Adds the nodes in the subtree rooted at 't' that are distance K - dist from the given node.*/
    public void subtree_add(List<Integer> ans, TreeNode node, int dist, int K) {
        if (node == null) return;
        if (dist == K) ans.add(node.val);
        else {
            subtree_add(ans, node.left, dist + 1, K);
            subtree_add(ans, node.right, dist + 1, K);
        }
    }

}
