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
        memo = new Integer[n + 1][target + 1];
        faces = k;
        return dp(n, target);
        // return dp(n, k, target);
    }
    // public int dp(int d, int f, int target) {
    //     if(d==0||target<0) return target==0?1:0;
    //     if(memo[d][target]!=null) return memo[d][target];
    //     int ways=0;
    //     for(int i=1;i<=f;i++) ways=(ways+dp(d-1,f,target-i))%1000000007; 
    //     return memo[d][target]=ways;
    // }
}

    