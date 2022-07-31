class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int valley = Integer.MAX_VALUE;
        int peak = valley;
        
        for(int day = 0; day < prices.length; day++){
            if(prices[day] < peak){
                totalProfit += peak - valley;
                valley = prices[day];
                peak = valley;
            }else {
                peak = prices[day];
            }
        }
        //if the last day is a peak
        totalProfit += peak - valley;
        return totalProfit;
    }
    //time complexity = O(n)
    //space complexity = O(1)
}