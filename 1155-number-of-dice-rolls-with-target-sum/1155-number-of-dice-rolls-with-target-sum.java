class Solution {
    private Integer[][] memo;
    private final int MOD = 1000000007;
    private int faces;
    
    private int dp(int dice, int target){
        if(target < 0){
            return 0;
        }
        if(dice == 0){
            return target == 0 ? 1 : 0;
        } 
        if(memo[dice][target] != null){
            return memo[dice][target];
        }
        
        long ways = 0;            
        for(int face = 1; face <= faces; face++){
            ways = (ways + dp(dice - 1, target - face)) % MOD;
        }
        return memo[dice][target] = (int)ways;
    }
    public int numRollsToTarget(int n, int k, int target) {
        memo = new Integer[n + 1][target + 1];//decide which variables to store in memo
        faces = k;//constant for all dices
        return dp(n, target);
    }
}