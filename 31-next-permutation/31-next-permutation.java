class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len != 0){
            int right = len - 2;
            while(right >= 0 && nums[right + 1] <= nums[right]) right--;
            if(right >= 0) {
                int largThanRight = len - 1;
                while(largThanRight >= 0 && nums[largThanRight] <= nums[right]) largThanRight--;
                swap(nums, right, largThanRight);
            }
            for(int start = right + 1, last = len - 1; start < last; start++, last--) swap(nums, start, last);
        }
    }
    private void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}