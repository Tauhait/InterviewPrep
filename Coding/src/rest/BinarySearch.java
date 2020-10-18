package rest;

public class BinarySearch {
	public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        return helper(nums, 0, nums.length - 1, target);
    }
    private int helper(int[] nums, int left, int right, int target){
        if(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) return helper(nums, left, mid - 1, target);
            else return helper(nums, mid + 1, right, target);
        }        
        else return -1;
    }
}
