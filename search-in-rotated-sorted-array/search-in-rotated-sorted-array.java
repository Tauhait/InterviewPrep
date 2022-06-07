class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) >>> 1;
            
            if(nums[mid] == target) return mid;
            else if(nums[mid] >= nums[low]){//non-rotated side
                if(target >= nums[low] && target < nums[mid]) high = mid - 1;
                else low = mid + 1;
            }else {//rotated side
                if(target > nums[mid] && target <= nums[high]) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}