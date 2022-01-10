class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int prefixSum = 0;
        int winStart = 0;
        int minSubArr = Integer.MAX_VALUE;
        for(int winEnd = 0; winEnd < nums.length; winEnd++){
            prefixSum += nums[winEnd];
            while(prefixSum >= target){
                minSubArr = Math.min(minSubArr, winEnd - winStart + 1);
                prefixSum -= nums[winStart];
                winStart++;
            }
        }
        return minSubArr == Integer.MAX_VALUE? 0 : minSubArr;
    }
}