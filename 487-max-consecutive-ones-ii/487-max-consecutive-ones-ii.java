class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int prevZero = -1, lastZero = 0;
        int maxLen = 0;
        int i = 0;
        for(; i < nums.length; i++){
            if(nums[i] == 0) {
                if(prevZero == -1) {
                    prevZero = i;
                    continue;
                }
                else {
                    maxLen = Math.max(maxLen, i-lastZero);
                    lastZero = prevZero+1;
                }
                prevZero = i;
            }
        }
        maxLen = Math.max(maxLen, i-lastZero);
        return maxLen;
    }
}