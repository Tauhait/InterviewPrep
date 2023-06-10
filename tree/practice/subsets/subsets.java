class Solution {
    private List<List<Integer>> subsets;

    private void findSubsets(int[] nums, int start, List<Integer> subset){
        if(start == nums.length) {
            return;
        }
        for(int i = start; i < nums.length; i++){
            subset.add(nums[i]);
            findSubsets(nums, i+1, subset);
            subsets.add(new ArrayList<Integer>(subset));         
            subset.remove(subset.size()-1);
        }
        return;
    }
    public List<List<Integer>> subsets(int[] nums) {
        subsets = new ArrayList<>();
        subsets.add(new ArrayList<Integer>());
        findSubsets(nums, 0, new ArrayList<>());
        return subsets;
    }
}