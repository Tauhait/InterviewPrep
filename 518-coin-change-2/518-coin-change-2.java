class Solution {
    private Integer[][] memo;
    private int amount;
    private int[] coins;
    
    private Integer dp(int coinsUsed, int amountLeft){
        if(amountLeft == 0){
            return 1;
        }
        if(amountLeft < 0 || coinsUsed == 0){
            return 0;
        }
        if(memo[coinsUsed][amountLeft] == null){
            int coinAmount = coins[coinsUsed - 1];
            int usingCurrCoin = dp(coinsUsed, amountLeft - coinAmount);
            int withoutUsingCurrCoin = dp(coinsUsed - 1, amountLeft);
            memo[coinsUsed][amountLeft] = usingCurrCoin + withoutUsingCurrCoin;
        }
        return memo[coinsUsed][amountLeft];
    }
    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.amount = amount;
        memo = new Integer[coins.length + 1][amount + 1];
        return dp(coins.length, amount);
    }
}