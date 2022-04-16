class Solution {
    private int[] prices;
    private int[][][] memo;
    
    private int dp(int i, int remTransaction, int isHolding){
        if(remTransaction == 0 || i == prices.length){
            return 0;
        }
        if(memo[i][remTransaction][isHolding] == 0){        
            int doNothing = dp(i + 1, remTransaction, isHolding);
            int sellStock = prices[i] + dp(i + 1, remTransaction - 1, 0);
            int buyStock = -prices[i] + dp(i + 1, remTransaction, 1);
            memo[i][remTransaction][isHolding] = isHolding == 1 ? Math.max(doNothing, sellStock) : 
                                                        Math.max(doNothing, buyStock);
        }
        return memo[i][remTransaction][isHolding];
    }
    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        memo = new int[prices.length][k + 1][2];
        
        return dp(0, k, 0);
    }
}