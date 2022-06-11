class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        int left = 0, right = 0, res = Integer.MAX_VALUE;
        for(int num : nums) sum += num;
        while(left <= right){
            if(sum >= x){
                if(sum == x) res = Math.min(res, left + nums.length - right);
                if(right < nums.length) sum -= nums[right++];
                else break;
            }else sum += nums[left++];
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}