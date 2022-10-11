class Solution {
    private int findUpperBoundBinarySearch(long[] dp, int key){
        int low = 0, high = dp.length-1;
        while(low < high){
            int mid = (low+high)>>>1;
            if(dp[mid] < key)
                low = mid + 1;
            else 
                high = mid;
        }
        return low;
    }
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        long[] dp = new long[n+1];
        for(int i = 1; i <= n; i++)
            dp[i] = Long.MAX_VALUE;
        dp[0] = Long.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int j = findUpperBoundBinarySearch(dp, nums[i]);
            if (j > 0 && dp[j-1] < nums[i] && nums[i] < dp[j])
                dp[j] = nums[i];
        }
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[i] < Long.MAX_VALUE)
                ans = i;
        }
        return ans >= 3;
    }
}