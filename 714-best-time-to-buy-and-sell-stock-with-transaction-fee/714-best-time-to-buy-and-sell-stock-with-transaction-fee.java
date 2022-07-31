class Solution {
    public int maxProfit(int[] prices, int fee) {
        int days = prices.length;
        int profitSoFarIfWeSell = 0;
        int profitSoFarIfWeBuy = profitSoFarIfWeSell-prices[0];
        /*
        If I am holding a share after today, then 
        either I am just continuing holding the share I had yesterday, or 
        that I held no share yesterday, but bought in one share today: 
        hold = max(hold, cash - prices[i])
        
        If I am not holding a share after today, then 
        either I did not hold a share yesterday, or 
        that I held a share yesterday but I decided to sell it out today: 
        cash = max(cash, hold + prices[i] - fee).
        
        Make sure fee is only incurred once.
        */
        for(int day = 1; day < days; day++){
            profitSoFarIfWeSell = Math.max(profitSoFarIfWeSell, 
                                           profitSoFarIfWeBuy+prices[day]-fee);
            profitSoFarIfWeBuy = Math.max(profitSoFarIfWeBuy, 
                                          profitSoFarIfWeSell-prices[day]);
        }
        return profitSoFarIfWeSell;
    }
}