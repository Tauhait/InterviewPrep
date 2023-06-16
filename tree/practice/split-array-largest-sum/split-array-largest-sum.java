class Solution {
    private boolean isSplitPossible(int[] nums, int splitSum, int k){
        int splits = 0;
        int subarraySum = 0;
        for(int i = 0; i < nums.length; i++){
            if(subarraySum + nums[i] > splitSum){
                ++splits;
                subarraySum = 0;
            }
            subarraySum += nums[i];
        }
        return (splits + 1) <= k;
    }
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int lo = 0;
        int hi = 0;
        for(int i = 0; i < n; i++){
            lo = Math.max(lo, nums[i]);
            hi += nums[i];
        }
        int splitSum = 0;
        int minLargSplitSum = 0;
        while(lo <= hi){
            splitSum = (lo + hi) >>> 1;
            if(isSplitPossible(nums, splitSum, k)){
                hi = splitSum - 1;
                minLargSplitSum = splitSum;
            } else {
                lo = splitSum + 1;
            }
        }
        return minLargSplitSum;
    }
}