class Solution {
    final int MOD = 1000000007;
    
    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo = new int[n + 1][target + 1];
        // Intialize the base case
        memo[n][target] = 1;
        
        for (int diceIndex = n - 1; diceIndex >= 0; diceIndex--) {
            for (int currSum = 0; currSum <= target; currSum++) {
               int ways = 0;
                
                // Iterate over the possible face value for current dice
                for (int i = 1; i <= Math.min(k, target - currSum); i++) {
                    ways = (ways + memo[diceIndex + 1][currSum + i]) % MOD;
                }
                
                memo[diceIndex][currSum] = ways;
            }
        }
        
        return memo[0][0];
    }
}