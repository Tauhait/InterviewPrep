class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        //Brute force - O(N*N)
        //Better - O(N log N) sort then two pointers
        //Best - if range of nums is fixed then use counting sort
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        int ans = -1;
        while(lo < hi){
            int sum = nums[lo] + nums[hi];
            if(sum < k){
                ans = Math.max(sum, ans);
                lo++;
            }else {
                hi--;
            }
        }
        return ans;
    }
}