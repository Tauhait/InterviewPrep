class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        
        for(int i = 0; i < len; i++){
            int diff = target - numbers[i];
            int j = binarySearch(numbers, diff, i);
            if(j != -1){
                return new int[]{i+1, j+1}; 
            }
        }
        return new int[]{-1, -1};
    }
    private int binarySearch(int[] nums, int key, int i){
        int low = i+1, high = nums.length-1;
        
        while(low <= high){
            int sum = nums[low] + nums[high];
            int mid = (low + high) >>> 1;
            if(nums[mid] > key) high = mid-1;
            else if(nums[mid] < key) low = mid+1;
            else return mid;
        }
        return -1;
    }
}