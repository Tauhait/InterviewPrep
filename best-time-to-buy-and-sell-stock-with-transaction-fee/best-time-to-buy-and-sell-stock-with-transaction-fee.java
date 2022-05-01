/**

If I am holding a share after today, then either I am just continuing holding the share I had yesterday, or that I held no share yesterday, but bought in one share today: hold = max(hold, cash - prices[i])

If I am not holding a share after today, then either I did not hold a share yesterday, or that I held a share yesterday but I decided to sell it out today: cash = max(cash, hold + prices[i] - fee).
Make sure fee is only incurred once.


The following concepts may help:
cash = profit, should always be positive
hold = balance, can be negative or positive.
on i-th day,

If you do not have a share, your profit is the same as previous day's profit.
If you hold a share already, you can always get more money when you sell (the prices[i]). But can you earn profit? it depends the balance, so profit = balance + prices[i] - fee when you sell a share on i-th day.
So on i-th day, max profit = max (profit, balance + prices[i] - fee) (not sell or sell)
now, we need to know how to calculate balance.
on i-th day

If you already have a share, you cannot buy another share, the balance is the same as previous day's balance.
If you have no share, so you must have profit (may be 0) and we can use profit to buy a share at cost of prices[i]. After buying a share, balance = profit - prices[i]
So on i-th day, max balance = max(balance, profit - prices[i]. We need maximize balance since we can get more profit when we sell a share.
Note:

On a specific day, you either hold a share or not. When you hold a share, we talk about balance. Since you haven't sell you share, we cannot talk about profit.
When you have no share, you must have profit (cash) since you have sold your share.
Why we need calculate profit and balance both each day? Because we don't know the status of each day. To get max profit, we need take account of both situation for each day.
On day one, profit=0 since we have no share to sell. balance = -prices[0] since we need buy a share and we only talk about balance when we have a share.
In the loop, since we calculate profit based on previous balance, so we need calculate today's profit first, then update the balance of today.

*/

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int profit = 0;
        int minimum = prices[0];
        for(int i = 1; i < len; i++){
            if(prices[i] < minimum){   // find the min price
                minimum = prices[i];
            }else if(prices[i] > minimum + fee){  // only price[i] - minimum - fee > 0 we can increase profit(ans) 
                profit += prices[i] - fee - minimum ; 
                // every sell need to pay fee, if next sell action, the revenue we get can‘t 
                // earn this fee back, then this sale is unnecessary, we will only loss more. 
                // So we let next minPrice(minimum) is prices[i] - fee, then if next time a 
                // certain price even is lower than prices[i] - fee we sell it, we can get more
                // revenue, and it can take back the loss(the fee)
                /**
                You need to buy a stock if the price goes down more than "fee" 
                since you last sold the stock, this is done by comparing your last balance to 
                what your balance would be if you were to sell it now. Soo you don't want to buy 
                unless the price goes down more than fee because even 
                if the price goes back up again after this, you'll make more money 
                by holding on to your previous position.
                
                Imagine a test case where [1,8, 9]
                Here when we encounter 8, we would attempt to sell it and gain our profit.
                However, there is a higher selling price that follows. 
                In such a case, we would just add the difference between the profit we collected 
                when selling 8 with the difference between the two selling points ( 9 and 8 ).
                In summary, it's treating the case as if 
                it meant to only sell the product it bought for the cost of 1 at the cost of 9.
                */
                minimum = prices[i] - fee;
            }
        }
        return profit;
    }
}