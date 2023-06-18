class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if((mid & 1) == 1) mid--; //make mid even index
            if(nums[mid] == nums[mid + 1]){
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
}