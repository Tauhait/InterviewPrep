class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int evenPointer = -1;
        int oddPointer = nums.length;
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                result[++evenPointer] = nums[i];
            }else {
                result[--oddPointer] = nums[i];
            }
        }
        return result;
    }
}