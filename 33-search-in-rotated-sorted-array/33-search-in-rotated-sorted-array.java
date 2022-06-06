class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        
        if(nums.length == 1)
            return (nums[0] == target ? 0 : -1);
        if(nums.length == 2)
            return (nums[0] == target ? 0 : (nums[1] == target ? 1 : -1));        
        
        int len = nums.length;       
        int low = 0, high = len - 1, mid = low + (high - low)/2;          
        return searchRotArray(low, high, nums, target);           
    }
    public int searchRotArray(int low, int high, int[] nums, int target){
        while(low <= high){            
            int mid = low + (high - low)/2;  
            // System.out.println("Mid: " +mid+", Low: "+low+", High: "+high+" ||| Value at mid: "+nums[mid]);
            
            if(nums[low] == target)
                return low;
            if(nums[high] == target)
                return high;
            if(nums[mid] == target)
                return mid;
            
            int f = nums[low];
            int l = nums[high];
            if(l < f){
                if(target > nums[mid] && target < l){
                    low = mid + 1;
                } else if(target < nums[mid] && target > f){
                    high = mid - 1;
                } else {                                            
                    int retVal = searchRotArray(low, mid - 1, nums, target);
                    if(retVal == -1){
                        retVal = searchRotArray(mid + 1, high, nums, target);
                    } 
                    return retVal;                   
                }
            } else {
                if(target < nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        
        return -1;
    }
}