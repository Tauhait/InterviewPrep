class Solution {
    public int maxProfit(int[] prices) {
        int largestDiff = 0;
        int minSoFar = Integer.MAX_VALUE;
        for(int buyDay = 0; buyDay < prices.length; buyDay++){
            minSoFar = Math.min(minSoFar, prices[buyDay]);
            largestDiff = Math.max(largestDiff, prices[buyDay] - minSoFar);
        }
        return largestDiff;
    }
}
//BF: Evaluate all possible days for buying and selling which will cost O(n*n)
//kadane's algo O(n)