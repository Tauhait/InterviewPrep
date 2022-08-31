class Solution {
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private void reverse(int[] arr, int i, int j){
        while(i <= j) swap(arr, i++, j--);
    }
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int len = nums.length;
        int i = len-2;
        while(i >= 0 && nums[i] >= nums[i+1]) i--;
        if(i >= 0){
            int j = len-1;
            while(nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i+1, len-1);
    }
}