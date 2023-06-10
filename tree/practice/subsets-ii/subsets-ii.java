class Solution { 
    private List<List<Integer>> subsets;
    private void findSubsets(int[] nums, int start, List<Integer> subset, Set<String> uniqueSubsets){
        subsets.add(new ArrayList<Integer>(subset));
        if(start < nums.length) {
            for(int i = start; i < nums.length; i++){
                if(i != start && nums[i] == nums[i-1]) continue;
                subset.add(nums[i]);
                findSubsets(nums, i+1, subset, uniqueSubsets);
                subset.remove(subset.size()-1);
            }
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<String> uniqueSubsets = new HashSet<>();
        subsets = new ArrayList<List<Integer>>();
        findSubsets(nums, 0, new ArrayList<Integer>(), uniqueSubsets);
        return subsets;

    }
}