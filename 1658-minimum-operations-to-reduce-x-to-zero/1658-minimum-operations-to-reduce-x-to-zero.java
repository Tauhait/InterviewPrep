class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int idx = 0; idx < nums.length; idx++){
            total += nums[idx];
        }
        int toFind = total - x;
        int winLeft = 0, winRight;
        int winSum = 0;
        int longest = -1;
        for(winRight = 0; winRight < nums.length; winRight++){
            winSum += nums[winRight];
            while(winSum > toFind && winLeft <= winRight){
                winSum -= nums[winLeft];
                winLeft++;
            }
            if(winSum == toFind){
                longest = Math.max(longest, winRight - winLeft + 1);
            }
        }
        return longest != -1 ? nums.length - longest : longest; 
    }
}