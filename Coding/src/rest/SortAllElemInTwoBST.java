package rest;

import java.util.ArrayList;
import java.util.List;

public class SortAllElemInTwoBST {
	class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	      TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	         this.val = val;
	         this.left = left;
	         this.right = right;
	      }
	}
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> sortedList = new ArrayList<Integer>();
        inorder(root1, sortedList);
        int m = sortedList.size();
        inorder(root2, sortedList);
        int n = sortedList.size();
        for(int i = m; i < n; i++){
            int val = sortedList.get(i);
            sortedList.remove(i);
            int j = i - 1;
            for( ; j >= 0; j--) if(val > sortedList.get(j)) break;
            sortedList.add(j + 1, val);            
        }
        return sortedList;
    }
    private void inorder(TreeNode root, List<Integer> traversal){
        if(root != null){
            inorder(root.left, traversal);
            traversal.add(root.val);
            inorder(root.right, traversal);
        }
    }
    // We can use the mergeList method to merge two sorted lists but then aux space would be O(N)
    @SuppressWarnings("unused")
	private List<Integer> mergeList(List<Integer> list1, List<Integer> list2) {
        List<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()) {
            if(list1.get(i) < list2.get(j)) list.add(list1.get(i++));
            else list.add(list2.get(j++));
        }
        
        while(i < list1.size()) list.add(list1.get(i++));
        while(j < list2.size()) list.add(list2.get(j++));
        
        return list;
    }

}
