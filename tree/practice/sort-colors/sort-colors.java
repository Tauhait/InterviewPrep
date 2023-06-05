class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zeroIndex = -1;
        int twoIndex = n;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0) {
                ++zeroIndex;
            }else if(nums[i] == 2){
                --twoIndex;
            }
        }
        for(int i = 0; i <= zeroIndex; i++){
            nums[i] = 0;
        }
        for(int i = zeroIndex+1; i < twoIndex ; i++){
            nums[i] = 1;
        }
        for(int i = twoIndex; i < n ; i++){
            nums[i] = 2;
        }
    }
}