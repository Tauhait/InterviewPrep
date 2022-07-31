class Solution {
    //bidirectional DP
    //Div-&-Conq
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[] leftProfit = new int[days];
        int[] rightProfit = new int[days+1];
        int maxProfit = 0;
        //+1 to accomodate only one transaction
        int minSoFarLeft = prices[0];
        int maxSoFarRight = prices[days-1];
        for(int day = 1; day < days; day++){
            minSoFarLeft = Math.min(minSoFarLeft, prices[day]);
            leftProfit[day] = Math.max(leftProfit[day-1], 
                                       prices[day]-minSoFarLeft);
            
            int daysReverse = days-1-day;
            maxSoFarRight = Math.max(maxSoFarRight, prices[daysReverse]);
            rightProfit[daysReverse] = Math.max(rightProfit[daysReverse+1], 
                                                maxSoFarRight-prices[daysReverse]);
        }
        
        for(int day = 0; day < days; day++){
            maxProfit = Math.max(leftProfit[day] + rightProfit[day+1], maxProfit);
        }
        return maxProfit;        
    }
}