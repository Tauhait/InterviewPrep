class Solution {
    private int[][] memo;
    private int[] nums;
    private int dp(int index, int prevIndex){
        if(index == nums.length){
            return 0;
        }
        if(memo[index][prevIndex + 1] != -1){
            return memo[index][prevIndex + 1];
        }
        
        //including prev index into result
        int len = dp(index + 1, prevIndex);
         
        if(prevIndex == -1 || nums[index] > nums[prevIndex]){
            //not including prev index results
            len = Math.max(len, 1 + dp(index + 1, index));
        }
        
        memo[index][prevIndex + 1] = len;
        
        return memo[index][prevIndex + 1];
    }
    public int lengthOfLIS(int[] nums) {
        this.nums = nums;
        int len = nums.length;
        
        memo = new int[len][len + 1];
        
        for(int i = 0; i < len; i++){
            Arrays.fill(memo[i], -1);
        }       
        
        return dp(0, -1);
    }
}