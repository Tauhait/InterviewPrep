class Solution {
    public int removeDuplicates(int[] nums) {
        int uniqIndex = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]) continue;
            nums[uniqIndex++] = nums[i];
        }
        return uniqIndex;
    }
}