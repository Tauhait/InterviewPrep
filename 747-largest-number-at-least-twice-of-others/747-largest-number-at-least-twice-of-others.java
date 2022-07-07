class Solution {
    public int dominantIndex(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > largest){
                secondLargest = largest;
                largest = nums[i];
                index = i;
            }else {
                secondLargest = Math.max(secondLargest, nums[i]);
            }
        }
        return largest/2 >= secondLargest ? index : -1; 
    }
}
//find the largest and second largest elements in the array
//if largest is 2x of second largest then return largest element index
//else -1