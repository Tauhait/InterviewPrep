class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int elemPointer = -1;
        int boundaryPointer = 0;
        while(boundaryPointer < nums.length){
            if(nums[boundaryPointer] != 0){
                int swapVar = nums[boundaryPointer];
                ++elemPointer;
                nums[elemPointer] = swapVar;
                if(elemPointer != boundaryPointer){
                    nums[boundaryPointer] = 0;
                }
            }
            ++boundaryPointer;
        }
    }
}