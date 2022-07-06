class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        int leftsum = 0, rightsum = 0;
        prefix[0] = nums[0];
        
        for(int i = 1; i < nums.length; i++) prefix[i] = prefix[i-1]+nums[i];
        
        for(int i = 0; i < nums.length; i++){
            if(i != 0) leftsum = prefix[i-1];
            rightsum = prefix[nums.length-1]-prefix[i];
            if(leftsum == rightsum) return i;
        }
        return -1;
    }
}