class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int low = 0, high = len - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            
            //intuition: go towards the peak of the current asc/desc seq by comparing (mid) & (mid + 1)
            //if desc then go towards left to find peak
            //if asc go towards right to find peak
            //also note contrainsts to be assumed nums[-1] = nums[n] = -∞.
            
            if(nums[mid] > nums[mid + 1]){//peak is in left side
                high = mid;
            }else {//peak is in right side
                low = mid + 1;
            }            
        }
        return high;
    }
}