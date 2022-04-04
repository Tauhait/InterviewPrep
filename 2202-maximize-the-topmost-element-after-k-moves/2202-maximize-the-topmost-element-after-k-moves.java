class Solution {
    public int maximumTop(int[] nums, int k) {
        if(k < 1){
            return nums[0];
        }
        if(nums.length == 1){
            return k == 1 ? -1 : k % 2 == 0 ? nums[0] : -1;                       
        }

        int maxSoFar = -1;
        int i = 0;
        for(; i < nums.length && k > 1; i++, k--){
            maxSoFar = Math.max(maxSoFar, nums[i]);
        }
        return (i + 1 >= nums.length ? maxSoFar : Math.max(maxSoFar, nums[i + 1]));
    }
}