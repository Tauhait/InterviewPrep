class Solution {
    private int nWays = 0;
    public int findTargetSumWays(int[] nums, int target) {
        findNWays(nums, target, 0, 0);
        return nWays;
    }
    public boolean findNWays(int[] nums, int target, int sum, int index){
        //System.out.println(sum);
        if(index == nums.length){ 
            return sum == target;
        }
        if(index < nums.length){
            if(findNWays(nums, target, sum - nums[index], index + 1)){
                nWays++;
            }
            if(findNWays(nums, target, sum + nums[index], index + 1)){
                nWays++;
            }
        }
        return false;
    }
}