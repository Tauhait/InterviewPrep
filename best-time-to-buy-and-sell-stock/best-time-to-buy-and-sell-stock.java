public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)//buy if least price encountered till now 
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)//sell if maxprofit till now
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}