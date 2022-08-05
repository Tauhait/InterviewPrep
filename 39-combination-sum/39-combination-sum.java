class Solution {
    
    private void generateCombinations(int start, int sum, int target, int[] nums,
                                            List<List<Integer>> ans, List<Integer> curr){
        if(sum > target) return;
        if(sum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int pos = start; pos < nums.length; pos++){
            curr.add(nums[pos]);
            sum += nums[pos];
            generateCombinations(pos, sum, target, nums, ans, curr);
            curr.remove(curr.size()-1);
            sum -= nums[pos];
        }
    } 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int pos = 0; pos < candidates.length; pos++){
            List<Integer> curr = new ArrayList<>();
            curr.add(candidates[pos]);
            generateCombinations(pos, candidates[pos], target, candidates, ans, curr);
        }
        return ans;
    }
}