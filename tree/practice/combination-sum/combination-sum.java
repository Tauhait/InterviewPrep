class Solution {
    private List<List<Integer>> combinations;
    private void findCombinations(int[] nums, int target, 
                                    int start, List<Integer> subset){
        if(target == 0){
            combinations.add(new ArrayList<Integer>(subset));
        }
        else if(start < nums.length && nums[start] <= target){
            for(int i = start; i < nums.length; i++){
                // if(i > start && nums[i] == nums[i-1]) continue;
                subset.add(nums[i]);
                findCombinations(nums, target-nums[i], i, subset);
                subset.remove(subset.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinations = new ArrayList<List<Integer>>();
        findCombinations(candidates, target, 0, new ArrayList<Integer>());
        return combinations;
    }
}