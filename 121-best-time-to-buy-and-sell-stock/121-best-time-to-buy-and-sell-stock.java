class Solution {
/** Kadane Algo
// Given an input array of numbers "nums",
1. best = negative infinity
2. current = 0
3. for num in nums:
    3.1. current = Max(current + num, num)
    3.2. best = Max(best, current)

4. return best
*/
    
    public int maxProfit(int[] prices) {
        if(prices.length < 2){
            return 0;
        }
        int best = Integer.MIN_VALUE;
        if(prices.length == 2){
            best = prices[1] - prices[0];
            return best < 0 ? 0 : best;
        }
        
        int[] profit = new int[prices.length - 1];
        for(int i = 1; i < prices.length; i++){
            profit[i - 1] = prices[i] - prices[i - 1];
        }
        
        int curr = 0;
        for(int p : profit){
            curr = Math.max(curr + p, p);
            best = Math.max(best, curr);
        }
        return best < 0 ? 0 : best;
    }
}