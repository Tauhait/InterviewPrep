class Solution {
    public int missingElement(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        //actual no of missing values in the array
        int missingCount = nums[right] - nums[left] - (right - left);
        if(k > missingCount){
            //return the value from right end after 
            //substract the missing nos already in the array
            return nums[right] + (k - missingCount);
        }
        int updateK = k;
        while(left + 1 < right){
            int mid = left + (right - left)/2; 
            missingCount = nums[mid] - nums[left] - (mid - left);
            if(updateK > missingCount){
                updateK -= missingCount;
                left = mid;
            }else {
                right = mid;
            }           
        }
        //System.out.println("right = " + nums[right] + ", k = " + k);
        return nums[left] + updateK;
    }
}