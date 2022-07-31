class Solution {
    public int maxProfit(int k, int[] prices) {
        int days = prices.length;
        int maxProfit = 0;
        if(days == 0) return 0;
        if(2*k >= days) {
            int prevPrice = prices[0];
            for(int day = 1; day < days; day++){
                maxProfit += Math.max(0, prices[day]-prevPrice);
                prevPrice = prices[day];
            }
            return maxProfit;
        }
        int[] profits = new int[days];
        while(k-- > 0){
            int profit = 0;
            for(int day = 1; day < days; day++){
                profit = Math.max(profits[day], profit+prices[day]-prices[day-1]);
                profits[day] = Math.max(profits[day-1], profit);
            }
        }
        return profits[days-1];
    }
    //time complexity = O(nk)
    //space complexity = O(n)
}