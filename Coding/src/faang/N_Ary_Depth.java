package faang;

import java.util.List;

public class N_Ary_Depth {
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
	}
	public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        if(root.children == null || root.children.size() == 0){
            return 1;
        }
        int maxDepth = 0;
        for(int i = 0; i < root.children.size(); i++){
            maxDepth = Math.max(maxDepth, 1 + maxDepth(root.children.get(i)));
        }
        return maxDepth;
    }

}
