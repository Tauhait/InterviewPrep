class Solution {
    private final int NUM_DIGITS = 10;
    
    private void countingSort(int[] nums, int placeVal){
        int[] counts = new int[NUM_DIGITS];
        for(int num : nums)
            counts[(num/placeVal)%NUM_DIGITS]++;
        int startIndex = 0;
        for(int i = 0; i < NUM_DIGITS; i++){
            int count = counts[i];
            counts[i] = startIndex;
            startIndex += count;
        }
        int[] sortedArray = new int[nums.length];
        for(int num : nums){
            int idx = (num/placeVal)%NUM_DIGITS;
            sortedArray[counts[idx]] = num;
            counts[idx]++;
        }
        for(int i = 0; i < nums.length; i++)
            nums[i] = sortedArray[i];
    }
    private void radixSort(int[] nums, int maxVal){
        int placeVal = 1;
        while(maxVal/placeVal > 0){
            countingSort(nums, placeVal);
            placeVal *= 10;
        }
    }
    public int maximumGap(int[] nums) {
        int max = 0;
        for(int num : nums)
            max = Math.max(num, max);
        radixSort(nums, max);
        int maxDiff = 0;
        for(int i = 0; i < nums.length-1; i++)
            maxDiff = Math.max(maxDiff, nums[i+1]-nums[i]);
        return maxDiff;
    }
}