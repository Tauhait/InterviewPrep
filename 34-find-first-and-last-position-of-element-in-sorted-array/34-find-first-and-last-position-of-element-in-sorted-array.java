class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        
        if(nums == null || nums.length == 0) return result;
        
        int index = binarySearch(nums, 0, nums.length - 1, target);
        if(index == -1) return result;
        
        int leftBoundary = index, rightBoundary = index;
        int boundary = -1;
        do {
            boundary = binarySearch(nums, 0, leftBoundary - 1, target);
            leftBoundary = boundary == -1 ? leftBoundary : boundary;
        } while(boundary != -1);
        
        boundary = -1;
        do {
            boundary = binarySearch(nums, rightBoundary + 1, nums.length - 1, target);
            rightBoundary = boundary == -1 ? rightBoundary : boundary;
        } while(boundary != -1);
        
        result[0] = leftBoundary;
        result[1] = rightBoundary;
        return result;
    }
    private int binarySearch(int[] nums, int left, int right, int target){       
         while(left <= right){
            int mid = left + (right - left)/2;
            // System.out.println(left + "," + mid + "," + right);
            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target) right = mid - 1;
            else return mid;
        }
        return -1;
    }
}