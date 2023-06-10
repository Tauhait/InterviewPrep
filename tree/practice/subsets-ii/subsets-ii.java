class Solution { 
    private List<List<Integer>> subsets;
    private void findSubsets(int[] nums, int start, List<Integer> subset, Set<String> uniqueSubsets){
        if(start < nums.length) {
            for(int i = start; i < nums.length; i++){
                subset.add(nums[i]);
                findSubsets(nums, i+1, subset, uniqueSubsets);
                String thisSubset = subset.toString();
                if(!uniqueSubsets.contains(thisSubset)) {
                    subsets.add(new ArrayList<Integer>(subset));
                    uniqueSubsets.add(thisSubset);
                }
                subset.remove(subset.size()-1);
            }            
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<String> uniqueSubsets = new HashSet<>();
        subsets = new ArrayList<List<Integer>>();
        subsets.add(new ArrayList<Integer>());
        uniqueSubsets.add((new ArrayList<Integer>()).toString());
        findSubsets(nums, 0, new ArrayList<Integer>(), uniqueSubsets);
        return subsets;

    }
}