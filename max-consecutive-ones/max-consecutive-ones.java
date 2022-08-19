class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int start = 0, end = 0, max = 0;
        while(end < nums.length){
            if(nums[end] != 1) {
                max = Math.max(max, end-start);
                start = end+1;
            }
            end++;
        }
        max = Math.max(end-start, max);
        return max;
    }
}