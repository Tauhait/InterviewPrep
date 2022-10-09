class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        
        ArrayList<Integer> inorderList = new ArrayList<Integer>();
        getInOrder(root, inorderList);
        for(int i = 0, j = inorderList.size() - 1; i < j; ){
            if(inorderList.get(i) + inorderList.get(j) > k) j--;
            else if(inorderList.get(i) + inorderList.get(j) < k) i++;
            else return true;
        }
        return false;
    }
    private void getInOrder(TreeNode root, ArrayList<Integer> inorderList){
        if(root != null){
            getInOrder(root.left, inorderList);
            inorderList.add(root.val);
            getInOrder(root.right, inorderList);
        }
    }
}