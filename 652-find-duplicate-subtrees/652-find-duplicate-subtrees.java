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
    private Map<String, Integer> cnt;
    private List<TreeNode> dupNodes;
    private String split = ",";
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        cnt = new HashMap<>();
        dupNodes = new ArrayList<>();
        dfs(root);
        return dupNodes;
    }
    
    private String dfs(TreeNode node) {
        if (node == null) {
            return "null";
        }
        String left = dfs(node.left);
        String right = dfs(node.right);
        String rst = new StringBuilder().append(node.val).
                                        append(split).
                                        append(left).
                                        append(split).
                                        append(right).toString();
        if (cnt.containsKey(rst)) {
            if (cnt.get(rst) == 1) {
                dupNodes.add(node);
            }
            cnt.put(rst, cnt.get(rst) + 1);
        } else {
            cnt.put(rst, 1);
        }
        return rst;
    }
}