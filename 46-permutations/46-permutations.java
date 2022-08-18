class Solution {
    private List<List<Integer>> ans;
    
    private void backtrack(int[] nums, List<Integer> currentPermute, Set<Integer> permuteSet){
        if(currentPermute.size() == nums.length) {
            ans.add(new ArrayList<Integer>(currentPermute));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){ 
            if(permuteSet.contains(nums[i])) continue;
            currentPermute.add(nums[i]);
            permuteSet.add(nums[i]);
            backtrack(nums, currentPermute, permuteSet);
            int valRemove = currentPermute.remove(currentPermute.size()-1);
            permuteSet.remove(valRemove);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<List<Integer>>();
        backtrack(nums, new ArrayList<Integer>(), new HashSet<Integer>());
        return ans;
    }
    //time complexity  = O(n * n!)
    //space complexity = O(n!)
}