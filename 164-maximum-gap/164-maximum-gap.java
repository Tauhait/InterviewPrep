class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maxGap = 0;
        for(int i = 0; i < nums.length-1; i++){
            maxGap = Math.max(maxGap, nums[i+1]-nums[i]);
        }
        return maxGap;
    }
}