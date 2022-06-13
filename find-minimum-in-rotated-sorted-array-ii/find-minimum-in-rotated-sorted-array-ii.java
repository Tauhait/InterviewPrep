class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high){
            int mid = (low + high) >>> 1;
            if(nums[low] == nums[high] && nums[low] == nums[mid]) {
                low += 1;
                high -= 1;
            }
            else if(nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return nums[high];
    }
}