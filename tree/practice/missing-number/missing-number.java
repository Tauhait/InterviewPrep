class Solution {
    public int missingNumber(int[] nums) {
        int missing = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            missing ^= nums[i];
            missing ^= (i+1);
        }
        return missing;
    }
}