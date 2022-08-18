class Solution {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    private void backtrack(int[] nums, int index, LinkedList<Integer> temp){
        if(temp.size() == nums.length) return;
        for(int i = index; i < nums.length; i++){
            temp.add(nums[i]);
            backtrack(nums, i+1, temp);
            ans.add(new ArrayList<Integer>(temp));
            temp.removeLast();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new LinkedList<Integer>());
        ans.add(new ArrayList<Integer>());
        return ans;
    }
}