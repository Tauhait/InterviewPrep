class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        backtrack(nums, new ArrayList<Integer>(), ans);
        return ans;
    }
    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> ans){
        if(tempList.size() == nums.length){
            ans.add(new ArrayList<>(tempList));
        }else {
            for(int i = 0; i < nums.length; i++){
                if(!tempList.contains(nums[i])){
                    tempList.add(nums[i]);
                    backtrack(nums, tempList, ans);
                    tempList.remove(tempList.size() - 1);  
                }                
            }
        }
    }
}