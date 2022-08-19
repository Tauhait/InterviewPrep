class Solution {
    private List<List<Integer>> ans;
    
    private void backtrack(List<Integer> tempList, int [] nums, boolean [] used){
        if(tempList.size() == nums.length){
            ans.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) continue;
            used[i] = true; 
            tempList.add(nums[i]);
            backtrack(tempList, nums, used);
            used[i] = false; 
            tempList.remove(tempList.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums, new boolean[nums.length]);
        return ans;
    }    
    //time complexity  = O(n * n!)
    //space complexity = O(n)
}
