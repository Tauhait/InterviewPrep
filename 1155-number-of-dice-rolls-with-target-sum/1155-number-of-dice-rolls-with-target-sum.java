class Solution {
    private Integer[][] memo;
    private int target;
    private final int MOD = 1_000_000_007;
    private int n, k;
    
    private int dp(int die, int sum){
        if(die == n)
            return sum == target ? 1 : 0;
        
        if(memo[die][sum] != null)
            return memo[die][sum];

        int ways = 0;
        for(int face = 1; face <= Math.min(k, target-sum); face++)
            ways = (ways + dp(die+1, sum+face)) % MOD;
        
        return memo[die][sum] = ways;
    }
    public int numRollsToTarget(int n, int k, int target) {
        this.n = n;
        this.k = k;
        this.target = target;
        memo = new Integer[n+1][target+1];
        return dp(0, 0);
    }
}