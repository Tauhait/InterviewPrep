class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == nums[mid - 1]){ // partner to the left
                int leftHalf  = (mid - 1) - lo;
                int rightHalf = (hi - mid);
                if((leftHalf & 1) == 1){ // left half is odd
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else if(nums[mid] == nums[mid + 1]){
                int leftHalf  = mid - lo;
                int rightHalf = hi - (mid + 1);
                if((leftHalf & 1) == 1){ // left half is odd
                    hi = mid - 1;
                } else {
                    lo = mid + 2;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];        
    }
}