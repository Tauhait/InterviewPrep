class Solution {
    public int maxSubArray(int[] nums) {
        int maxLocal = 0;
        int maxGlobal = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            maxLocal = Math.max(nums[i], maxLocal+nums[i]);
            maxGlobal = Math.max(maxLocal, maxGlobal);
        }
        return maxGlobal;
    }
}