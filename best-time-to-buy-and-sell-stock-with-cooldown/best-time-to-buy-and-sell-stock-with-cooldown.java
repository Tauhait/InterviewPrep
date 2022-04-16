class Solution {
    private int[] prices;
    private int[][] memo;

    private int dp(int i, int isHolding){
        if(i >= prices.length){
            return 0;
        }
        if(memo[i][isHolding] == 0){        
            int doNothing = dp(i + 1, isHolding);
            int sellStock = prices[i] + dp(i + 2, 0);
            int buyStock = -prices[i] + dp(i + 1, 1);
            memo[i][isHolding] = isHolding == 1 ? Math.max(doNothing, sellStock) : 
                                                        Math.max(doNothing, buyStock);
        }
        return memo[i][isHolding];
    }
    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new int[prices.length][2];

        return dp(0, 0);
    }
}