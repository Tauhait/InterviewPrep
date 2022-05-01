class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2 + 1][2];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int transactionsRemaining = 1; transactionsRemaining <= 2; transactionsRemaining++) {
                for (int holding = 0; holding < 2; holding++) {
                    int doNothing = dp[i + 1][transactionsRemaining][holding];
                    int doSomething;
                    if (holding == 1) {
                        // Sell stock
                        doSomething = prices[i] + dp[i + 1][transactionsRemaining - 1][0];
                    } else {
                        // Buy stock
                        doSomething = -prices[i] + dp[i + 1][transactionsRemaining][1];
                    }
                    
                    // Recurrence relation
                    dp[i][transactionsRemaining][holding] = Math.max(doNothing, doSomething);
                }
            }
        }
        
        return dp[0][2][0];
    }
}